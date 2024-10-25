package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

public class Post02 extends JsonPlaceHolderBaseUrl {
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
    public void test01() {
        specification.pathParam("first", "todos");

        String payload = "{\n" +
                "            \"userId\": 55,\n" +
                "            \"title\": \"Tidy your room\",\n" +
                "            \"completed\": false,\n" +
                "            \"id\": 201\n" +
                "        }";

        Response response = given(specification).body(payload).when().post("{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        assertEquals(55, jsonPath.getInt("userId"));
        assertEquals("Tidy your room", jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));
        assertEquals(201, jsonPath.getInt("id"));


        response.then().
                statusCode(201).
                contentType(ContentType.JSON).
                body("userId", equalTo(55)).
                body("title", equalTo("Tidy your room")).
                body("completed", equalTo(false)).
                body("id", equalTo(201)).
                log().
                body();
    }
}
