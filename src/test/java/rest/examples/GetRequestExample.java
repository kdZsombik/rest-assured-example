package rest.examples;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;


public class GetRequestExample {


    @BeforeEach
    void setUp()
    {
        RestAssured.baseURI = "http://services.groupkt.com";
        RestAssured.port = 80;
    }

    @Test
    @DisplayName("Testing that my Get Request has ")
    public void simpleGetRequestWithStatusCode()
    {
        when().get("/country/get/all").then()
                .statusCode(200);
    }

    @Test
    public void simpleGetRequestWithBodyValidation()
    {

    }
}
