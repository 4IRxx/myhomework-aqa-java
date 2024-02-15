import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;
public class PostmanEchoTests {
    Player saka = new Player("Saka", "FC Arsenal");
    Player arshavin = new Player("Arshavin", "FC Zenit");
    private RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        requestSpec = given()
                .log().all()
                .baseUri("https://postman-echo.com");
    }

    @Test
    public void testGET() {
        requestSpec.when()
                .get("/get")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPost() {
        requestSpec.given()
                .contentType(ContentType.JSON)
                .body(saka)
                .when()
                .post("/post")
                .then()
                .body("json.surename", equalTo(saka.getSurename()))
                .body("json.club", equalTo(saka.getClub()))
                .statusCode(200);
    }

    @Test
    public void testPut() {
        requestSpec.given()
                .contentType(ContentType.JSON)
                .body(arshavin)
                .when()
                .put("/put")
                .then()
                .body("json.surename", equalTo(arshavin.getSurename()))
                .body("json.club", equalTo(arshavin.getClub()))
                .statusCode(200);
    }

    @Test
    public void testPatch() {
        arshavin.setClub("Arsenal");
        requestSpec.given()
                .contentType(ContentType.JSON)
                .body(Collections.singletonMap("club", arshavin.getClub()))
                .when()
                .patch("/patch")
                .then()
                .body("json.club", equalTo(arshavin.getClub()))
                .statusCode(200);
    }

    @Test
    public void testDelete() {
        Response response = requestSpec
                .given()
                .contentType(ContentType.JSON)
                .body(arshavin)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(response.path("json.surename"), arshavin.getSurename());
        assertEquals(response.path("json.club"), arshavin.getClub());
    }
}
