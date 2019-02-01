package test.authentication.controller;

import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.*;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import org.junit.*;
import org.junit.rules.ExpectedException;


import java.text.ParseException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HomeControllerTest {
    private static EmbeddedServer server;
    private static RxHttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext
                .build()
                .run(EmbeddedServer.class);
        client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL()); // <2>

    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testIndex(){
        thrown.expect(HttpClientResponseException.class);
        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.UNAUTHORIZED))));
        client.toBlocking().exchange(HttpRequest.GET("/"));

//        thrown.expect(HttpClientResponseException.class);
//        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.OK))));
//        HttpRequest request = HttpRequest.GET("/").basicAuth("sherlock","password");
//        HttpResponse<BearerAccessRefreshToken> response = client.toBlocking().exchange(request, BearerAccessRefreshToken.class);
//        assertEquals(response.body().getAccessToken(),true);
//
    }

    @Test
    public  void testLogin() throws ParseException {
//
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("sherlock","password");
        HttpRequest request = HttpRequest.POST("/login", credentials);
        HttpResponse<BearerAccessRefreshToken> response = client.toBlocking().exchange(request, BearerAccessRefreshToken.class);
        assertEquals(HttpStatus.OK,response.status());
        assertEquals("sherlock",response.body().getUsername());
        assertNotNull(response.body().getAccessToken());
        assertThat(JWTParser.parse(response.body().getAccessToken()), instanceOf(SignedJWT.class));
        assertNotNull(response.body().getRefreshToken());
        assertThat(JWTParser.parse(response.body().getRefreshToken()), instanceOf(SignedJWT.class));

        String accessToken = response.body().getAccessToken();
        HttpRequest requestWithAuthorization = HttpRequest.GET("/").header(HttpHeaders.AUTHORIZATION, "Bearer "+accessToken);
        HttpResponse<String> response1 = client.toBlocking().exchange(requestWithAuthorization, String.class);
        assertEquals(HttpStatus.OK, response1.getStatus());
        assertEquals("sherlock",response1.body());


    }
}
