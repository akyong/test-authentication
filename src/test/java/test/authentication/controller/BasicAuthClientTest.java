package test.authentication.controller;


import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Base64;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class BasicAuthClientTest {

    private static EmbeddedServer server; // <1>
    private static AppClient client; // <2>

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.build().run(EmbeddedServer.class); // <1>

        client = server.getApplicationContext().createBean(AppClient.class); // <2>
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {

        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void verifyHttpBasicAuthWorks (){

        String hasilencode = Base64.getEncoder().encodeToString("sherlock:password".getBytes());
        String rsp = client.home("Basic "+hasilencode);
        assertEquals(rsp, "sherlock");
//        thrown.expect(HttpClientResponseException.class);
//        thrown.expect("",String.class);
//        client.toBlocking().exchange(HttpRequest.GET("/student/list?order=foo"));
//
//        String credsEncoded = Base64.getEncoder(userpassEncoded.getBytes());
//        String rsp = appClient.home("Basic ${credsEncoded}");

    }
}
