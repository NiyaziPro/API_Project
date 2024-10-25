package post_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Post01 extends PetStoreBaseUrl {
    /*
        Given
            https://petstore.swagger.io/v2/pet
        And
                        {
              "id": 7777,
              "category": {
                "id": 0,
                "name": "Dog"
              },
              "name": "Kurt",
              "photoUrls": [
                "ali","veli","can"
              ],
              "tags": [
                {
                  "id": 1,
                  "name": "string1"
                },
                  {
                  "id": 2,
                  "name": "string2"
                }
              ],
              "status": "available"
            }
        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
     */

    @Test
    public void test01() {
        specification.pathParam("first","pet");

        String payload = "{\n" +
                "  \"id\": 7777,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Dog\"\n" +
                "  },\n" +
                "  \"name\": \"Kurt\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"ali\",\"veli\",\"can\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"string1\"\n" +
                "    },\n" +
                "      {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"string2\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

       Response response= given(specification).body(payload).when().post("{first}");

       response.prettyPrint();

       response.then().
               statusCode(200).
               contentType(ContentType.JSON);
    }
}
