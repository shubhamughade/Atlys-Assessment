package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://searchserverapi.com";
    }

    // checking if API is giving 200 response
    @Test
    public void statusCodeCheck() {
        given()
            .queryParam("q", "plant")
        .when()
            .get("/getwidgets")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON);
    }

    // checking if response body has widgets in it
    @Test
    public void responseHasWidgets() {
        given()
            .queryParam("q", "air plant")
        .when()
            .get("/getwidgets")
        .then()
            .statusCode(200)
            .body("widgets", notNullValue());
    }

    // checking with wrong query, API should not fail badly
    @Test
    public void invalidQueryCheck() {
        given()
            .queryParam("q", "%%%%")
        .when()
            .get("/getwidgets")
        .then()
            .statusCode(anyOf(is(200), is(400)))
            .body("widgets.size()", greaterThanOrEqualTo(0));
    }
}

