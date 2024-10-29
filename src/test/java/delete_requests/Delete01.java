package delete_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;


public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos/198
    When
        I send DELETE Request to the Url
    Then
        Status code is 200
    And Response body is { }
*/

    @Test
    public void test01() {

        //Set the url
        specification.pathParams("first", "todos", "second", 198);

        // Set the expected data / payload :
        Map<String, Object> payload = new HashMap<>();
        // Send the request and get the response :

        Response response = given(specification).when().delete("{first}/{second}");

        // Do Assertion

        System.out.println("payload = " + payload);

        // 1.Way
        assertEquals(200, response.statusCode());

        // 2.Way
        response.then().statusCode(200);

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(payload,actualData);

    }
}
