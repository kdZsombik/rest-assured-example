package rest.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PutRequestExample {

    @BeforeEach
    void setUp()
    {
        RestAssured.baseURI = "http://localhost";
    }

    @AfterEach
    public void tearDown(){
        RestAssured.reset();
    }

    @Test
    public void simplePostRequestWithNoAuthentification()
    {
        given().body(" {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"Duo Tent\",\n" +
                "        \"price\": 150\n" +
                "    }").contentType(ContentType.JSON)
        .when().put("/api/campgemini/")
                .then().statusCode(401);
    }

    @Test
    public void simplePostRequestWithAuthentification()
    {
        given().header("role","employee")
                .body(" {\n" +
                "        \"id\": 5,\n" +
                "        \"name\": \"Opel Astra,\n" +
                "        \"price\": 35000\n" +
                "    }").contentType(ContentType.JSON)
                .when().put("/api/campgemini/")
                .then().statusCode(200);
    }
}
