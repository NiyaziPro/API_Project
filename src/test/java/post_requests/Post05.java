package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceholderPayloadPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post05 extends JsonPlaceHolderBaseUrl {

     /*
Given
   1) https://jsonplaceholder.typicode.com/todos
   2)  {
         "userId": 55,
         "title": "Tidy your room",
         "completed": false
       }
    When
        Kullanıcı URL'e bir POST request gönderir
    Then
        Status code 201 olmalı
    And
        Response şu şekilde olmalı:
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
 */

    @Test
    public void testUsingPojo() {

        // Set the url
        specification.pathParam("first","todos");

        // Set the expected data / Payload

        JsonPlaceholderPayloadPojo payload = new JsonPlaceholderPayloadPojo(55,"Tidy your room",false);

        // Send Request
        Response response = given(specification).body(payload).when().post("{first}"); // Serialization

        //Do Assertion

        JsonPlaceholderPayloadPojo actualData = response.as(JsonPlaceholderPayloadPojo.class); // De-Serization

        System.out.println("payload = " + payload);
        System.out.println("actualData = " + actualData);
        assertEquals(201,response.statusCode());
        assertEquals(payload.getUserId(),actualData.getUserId());
        assertEquals(payload.getTitle(),actualData.getTitle());
        assertEquals(payload.getCompleted(),actualData.getCompleted());


    }
}
