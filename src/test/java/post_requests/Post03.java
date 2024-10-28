package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;


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
    public void test01() {

        //Set the url :
        specification.pathParam("first","todos");

        // Set the expected data / payload :
        Map<String,Object> payload = new HashMap<>();
        payload.put("userId",55);
        payload.put("title","Tidy your room");
        payload.put("completed",false);


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


        // Do assertions

        assertEquals(jsonPath.getInt("userId"),payload.get("userId"));
        assertEquals(jsonPath.getString("title"),payload.get("title"));
        assertEquals(jsonPath.getBoolean("completed"),payload.get("completed"));

    }
}
