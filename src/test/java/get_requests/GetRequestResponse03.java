package get_requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.Assert;
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
                body("name", containsString("Lasi")).
                body("status", equalTo("available")).
                body("category.name", equalTo("Dog")).
                body("tags[0].name", equalTo("string1")).
                log().all();
    }

    @Test
    public void apiTestWithTestNG() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/7777";

        Response response = given().when().get();
        System.out.println(response.asString());

        Assert.assertTrue(response.asString().contains("Lasi"));
        Assert.assertFalse(response.asString().contains("techpro"));

        // Yanıtın status code'unu kontrol et
        Assert.assertEquals(response.getStatusCode(), 200, "Status code yanlış!");

        // Yanıtın Content-Type'ını kontrol et
        Assert.assertEquals(response.getContentType(), ContentType.JSON.toString(), "Yanıt Content-Type JSON değil!");

        // JSON yanıtından "name" değerini al ve doğrula
        String name = response.jsonPath().getString("name");
        Assert.assertTrue(name.contains("Lasi"), "'name' alanı 'Lasi' içermiyor!");

        // "status" alanını kontrol et
        String status = response.jsonPath().getString("status");
        Assert.assertEquals(status, "available", "'status' alanı 'available' değil!");

        // "category.name" alanını kontrol et
        String categoryName = response.jsonPath().getString("category.name");
        Assert.assertEquals(categoryName, "Dog", "'category.name' alanı 'Dog' değil!");

        // "tags[0].name" alanını kontrol et
        String firstTagName = response.jsonPath().getString("tags[0].name");
        Assert.assertEquals(firstTagName, "string1", "'tags[0].name' alanı 'string1' değil!");

        // Yanıtın tamamını logla (isteğe bağlı)
        response.prettyPrint();

    }

    @Test
    public void apiTestWithTestNG02() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/7777";

        Response response = given().when().get();

        Assert.assertTrue(response.asString().contains("Lasi"));
        Assert.assertFalse(response.asString().contains("techpro"));

        Assert.assertEquals(response.jsonPath().getString("tags[0].name"),"string1");
    }
}
