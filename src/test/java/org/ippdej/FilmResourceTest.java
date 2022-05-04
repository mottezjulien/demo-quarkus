package org.ippdej;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class FilmResourceTest {

    @Test
    public void testFilmEndpoint(){
        given().when().get("/film").then().statusCode(200);
        given().when().get("/film/download").then().statusCode(404);
    }
}
