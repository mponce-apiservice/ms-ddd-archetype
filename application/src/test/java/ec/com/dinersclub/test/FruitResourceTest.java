package ec.com.dinersclub.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FruitResourceTest {

    @Test
    public void testList() {
        given()
                .when().get("/fruits")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "name", containsInAnyOrder("Apple","Orange","Pear"));
    }

    @Test
    public void testAdd() {
        given()
                .body("{\"id\": 999, \"name\": \"Cherry\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/fruits")
                .then()
                .statusCode(201);

        given()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/fruits/999")
                .then()
                .statusCode(200);
    }
}