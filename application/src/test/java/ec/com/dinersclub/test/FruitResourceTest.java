package ec.com.dinersclub.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class FruitResourceTest {
	
	@Test
    public void testAdd() {
        given()
                .body("{\"id\": 1, \"name\": \"Apple\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/fruits")
                .then()
                .statusCode(201);

        given()
		        .body("{\"id\": 2, \"name\": \"Orange\"}")
		        .header("Content-Type", MediaType.APPLICATION_JSON)
		        .when()
		        .post("/fruits")
		        .then()
		        .statusCode(201);
        
        given()
		        .body("{\"id\": 3, \"name\": \"Pear\"}")
		        .header("Content-Type", MediaType.APPLICATION_JSON)
		        .when()
		        .post("/fruits")
		        .then()
		        .statusCode(201);
    }

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
    public void testRemove() {
        given()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/fruits/1")
                .then()
                .statusCode(200);
        
        given()
		        .header("Content-Type", MediaType.APPLICATION_JSON)
		        .when()
		        .delete("/fruits/2")
		        .then()
		        .statusCode(200);
        
        given()
		        .header("Content-Type", MediaType.APPLICATION_JSON)
		        .when()
		        .delete("/fruits/3")
		        .then()
		        .statusCode(200);
    }
    
}