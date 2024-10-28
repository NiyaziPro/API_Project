package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;


public class Post03 extends JsonPlaceHolderBaseUrl {

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
    public void testSerialization() {

        //Set the url :
        specification.pathParam("first", "todos");

        // Set the expected data / payload :
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 55);
        payload.put("title", "Tidy your room");
        payload.put("completed", false);


        // Send the request and get the response :

        Response response = given(specification).body(payload).when().post("{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        /*
Bir Java datasını json formatına dönüştürme işlemine serialization denir
Bir json datasını Java formatına dönüştürme işlemine deserialization denir
pom.xml dosyamiza eklemis oldugumuz Jackson databind .. gibi kütüphaneler serialization ve
de serialization islemlerini otomatik olarak yapar, bizim extra bir sey yapmamiza gerek kalmaz
 */

        payload.put("id", 201);

        // Do assertions

        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userId"), jsonPath.getInt("userId"));
        assertEquals(payload.get("title"), jsonPath.getString("title"));
        assertEquals(payload.get("completed"), jsonPath.getBoolean("completed"));
        assertEquals(payload.get("id"), jsonPath.getInt("id"));


    }

    @Test
    public void testDeSerialization() {

        //Set the url :
        specification.pathParam("first", "todos");

        // Set the expected data / payload :
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 55);
        payload.put("title", "Tidy your room");
        payload.put("completed", false);


        // Send the request and get the response :

        Response response = given(specification).body(payload).when().post("{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();


        payload.put("id", 201);

        // Do assertions
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("Actual data : " + actualData);
        System.out.println("Expected data :" + payload);

        assertEquals(payload, actualData);

        assertEquals(payload.get("userId"),actualData.get("userId"));
        assertEquals(payload.get("title"),actualData.get("title"));
        assertEquals(payload.get("completed"),actualData.get("completed"));
        assertEquals(payload.get("id"),actualData.get("id"));


    }
}
