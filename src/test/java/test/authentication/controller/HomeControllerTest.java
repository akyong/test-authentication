package test.authentication.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.*;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class HomeControllerTest {
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
    public void testIndex(){
        thrown.expect(HttpClientResponseException.class);
        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.UNAUTHORIZED))));
        client.toBlocking().exchange(HttpRequest.GET("/"));

        thrown.expect(HttpClientResponseException.class);
        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.OK))));
        HttpRequest request = HttpRequest.GET("/").basicAuth("sherlock","password");
        HttpResponse<String> response = client.toBlocking().exchange(request, String.class);
    }

    @Test
    public  void testLogin(){
//        thrown.expect(HttpClientResponseException.class);
//        thrown.expect(hasProperty("response", hasProperty("status", is(HttpStatus.OK))));
//        HttpRequest request = HttpRequest.GET("/").basicAuth("sherlock","password");
//        HttpResponse<String> response = client.toBlocking().exchange(request, String.class);

    }
}
