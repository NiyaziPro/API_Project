package patch_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
Given
    1) https://jsonplaceholder.typicode.com/todos/198
    2) {
          "title": "Wash the dishes"
       }
When
  I send PATCH Request to the Url
Then
      Status code is 200
      And response body is like
          {
            "userId": 10,
            "title": "Wash the dishes",
            "completed": true,
            "id": 198
          }
 */

    @Test
    public void test01() {
        //Set the url
        specification.pathParams("first", "todos", "second", 198);

        // Set the expected data / payload :

        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Wash the dishes");

        // Send the request and get the response :

        Response response = given(specification).body(payload).when().patch("{first}/{second}");

        // Do Assertion

        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(payload.get("title"), actualData.get("title"));

        payload.put("userId", 10);
        payload.put("completed", true);
        payload.put("id", 198);

        assertEquals(200,response.statusCode());

        assertEquals(payload.get("userId"),actualData.get("userId"));
        assertEquals(payload.get("completed"),actualData.get("completed"));
        assertEquals(payload.get("id"),actualData.get("id"));
    }
}