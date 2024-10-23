package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRequestResponse01 {


    @Test
    public void getRequestTest1() {
         /* Scenario
    Given
        https://petstore.swagger.io/v2/pet/320
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        Status Line "HTTP/1.1 200 OK" olmalı
*/

        //1) Set the url :
        //1. Way
//        String baseUrl = "https://petstore.swagger.io/v2";
//        String pathParameter = "/pet/7777";

        //2.Way
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/7777";

        //2 - set the expected data

        //3 - send request get response
        Response response = given().when().get();
        response.prettyPrint();

        //4 - Do Assertion
        response.
                then().assertThat().statusCode(200).
                and().assertThat().contentType("application/json").
                and().assertThat().statusLine("HTTP/1.1 200 OK");


    }

    @Test
    public void getRequestTest2() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/7777";

        //2 - set the expected data

        //3 - send request get response

        //4 - Do Assertion
        given().when().
                get().
                then().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK").log().body().log().all();
    }
}
