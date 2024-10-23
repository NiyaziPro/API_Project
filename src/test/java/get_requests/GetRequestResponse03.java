package get_requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestResponse03 {

    /*
    Given
        https://petstore.swagger.io/v2/pet/320
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        "name" şu metni içermeli: "Lasi",
    And
        "status" değeri "available" olmalı
    And
        "category" altındaki "name" değeri "Dog" olmalı
    And
        "tags" altındaki ilk datanin "name" değeri "string1" olmalı
 */

    @Test
    public void testGetRequest01() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/7777";


        given().when().
                get().
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("name",containsString("Lasi")).
                body("status",equalTo("available")).
                body("category.name",equalTo("Dog")).
                body("tags[0].name",equalTo("string1")).log().all();
    }
}
