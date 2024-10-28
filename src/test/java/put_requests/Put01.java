package put_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
        Kullanıcı URL'e bir PUT request gönderir
    Then
       Status code 200 olmalı
       Response şu şekilde olmalı:
       {
            "userId": 21,
            "title": "Wash the dishes",
            "completed": false
            "id": 198
       }
 */

    /*
    Before update(put)
        {
            "userId": 10,
            "id": 198,
            "title": "quis eius est sint explicabo",
            "completed": true
        }

     */


    @Test
    public void test01() {

        //Set the url
        specification.pathParams("first", "todos", "second", 198);

        // Set the expected data / payload :

        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 21);
        payload.put("title", "Wash the dishes");
        payload.put("completed", false);

        // Send the request and get the response :

        Response response = given(specification).body(payload).when().put("{first}/{second}");

        payload.put("id", 198);

        // Do Assertion

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(payload, actualData);

        assertEquals(payload.get("userId"),actualData.get("userId"));
        assertEquals(payload.get("title"),actualData.get("title"));
        assertEquals(payload.get("completed"),actualData.get("completed"));
        assertEquals(payload.get("id"),actualData.get("id"));
    }
}
