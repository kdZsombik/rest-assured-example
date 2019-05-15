package rest.examples;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


public class GetRequestExample {


    @BeforeEach
    void setUp()
    {
        RestAssured.baseURI = "http://services.groupkt.com";
        RestAssured.port = 80;
    }

    @AfterEach
    public void tearDown(){
        RestAssured.reset();
    }


    @Test
    @DisplayName("Testing that my Get Request has ")
    public void simpleGetRequestWithStatusCode()
    {
        RestAssured.reset();
        when().get("/country/get/all").then()
                .statusCode(200);
    }

    @Test
    public void simpleGetRequestWithBodyValidation()
    {
        when().get("/country/get/all")
                .then().body("RestResponse.result[0].name",containsString("Afghanistan"));

    }

    @Test
    @DisplayName("Validating that a request time is less than 20s")
    public void performanceMeasureOfGetRequest()
    {
        when().get("/country/get/all")
        .then().time(lessThan(20L),TimeUnit.SECONDS);

    }

}
