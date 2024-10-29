package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post04 extends JsonPlaceHolderBaseUrl {

    //OBJECT MAPPER
 /*
    Given
        1) https://jsonplaceholder.typicode.com/todos
        2) {"userId": 55,"title": "Tidy your room","completed": false}
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
 */

    @Test
    public void testPostRequest() throws JsonProcessingException {
        //Set the url :
        specification.pathParam("first", "todos");

        // Set the expected data / payload :

        /*
ObjectMapper kullanarak readValue methodu, birinci parametreyi string olarak alır,
ve ikinci parametreyi bizim bildiğimiz data type dönüştürür.
Bu bize ne sağladı?
Böylece datalari manual olarak
eklemek zorunda kalmayiz, otomatik olarak bize Map verir
Not ==> import com.fasterxml.jackson.databind.ObjectMapper;
 */
        ObjectMapper object = new ObjectMapper();
        String json = "{\"userId\": 55,\"title\": \"Tidy your room\",\"completed\": false}";
        Map<String, Object> payload = object.readValue(json, HashMap.class);

        System.out.println("payload = " + payload);

        // Send Request
        Response response = given(specification).body(payload).when().post("{first}");

        Map<String, Object> actualData = response.as(HashMap.class);

        // Do Assertion
        payload.put("id", 201);

        response.then().statusCode(201);
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));
        assertEquals(payload.get("id"), actualData.get("id"));



    }
}
