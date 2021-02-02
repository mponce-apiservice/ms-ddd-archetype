package ec.com.dinersclub.test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }
    
    /*@Test
    public void testHelloGrpc() {
        given()
          .when().get("/hello/gRPC")
          .then()
             .statusCode(200)
             .body(is("Hello gRPC"));
    }*/

}