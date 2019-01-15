package test.authentication.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.endpoints.TokenRefreshRequest;
import io.micronaut.security.token.jwt.render.AccessRefreshToken;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class OAuthRefreshTokenTest
{
    private static EmbeddedServer server; // <1>
    private static RxHttpClient client; // <2>

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext
                .build()
                .run(EmbeddedServer.class); // <1>
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
    public void testRefreshToken() throws InterruptedException {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("sherlock","password");
        HttpRequest request = HttpRequest.POST("/login", credentials);
        HttpResponse<BearerAccessRefreshToken> response = client.toBlocking().exchange(request, BearerAccessRefreshToken.class);
        assertEquals(HttpStatus.OK,response.status());

        Thread.sleep(1000);
        String accessToken = response.body().getAccessToken();
        String refreshToken = response.body().getRefreshToken();
        HttpResponse<AccessRefreshToken> response1 =
                client.toBlocking().exchange(
                        HttpRequest.POST("/oauth/access_token",new TokenRefreshRequest("refresh_token",refreshToken)),
                        AccessRefreshToken.class);

        assertEquals(response1.getStatus(), HttpStatus.OK);
        assertNotNull(response1.body().getAccessToken());
        assertNotEquals(response1.body().getAccessToken(), accessToken);
    }
}
