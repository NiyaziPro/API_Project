package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequestResponse05 extends PetStoreBaseUrl {

      /*
   Given
       https://petstore.swagger.io/v2/pet/findByStatus?status=available
   When
       Kullanıcı URL'e bir GET request gönderir
   Then
       HTTP Status Code 200 olmalı
   And
       Content Type "application/json" olmalı
   And
       Listede id değeri 7777 olan bir eleman olmalı
   And
       Listede name değeri "Lasi" olan bir eleman olmalı
   And
       Listede name değerleri "Lasi", "doggie", "fish" olan elemanlar olmalı
   And
       Listede en az 200 tane eleman olmalı
   And
       Listede 500'den az eleman olmalı
   And
       Listenin ilk elemanının category - id değeri 0 olmalı
   And
       Listenin ilk elemanının photoUrls değeri "string" olmalı
   And
       Listenin ilk elemanının tags - id değeri 0 olmalı
*/

    @Test
    public void testGetRequest01() {
        specification.pathParams("p1", "pet", "p2", "findByStatus").
                queryParam("status", "available");

        Response response = given(specification).when().
                get("{p1}/{p2}");

        response.prettyPrint();

        response.then().
                statusCode(200).
                contentType(ContentType.JSON.toString()).
                body("id", hasItem(7777)).
                body("name",hasItem("Lasi")).
                body("name",hasItems("Lasi","doggie","fish")).
                body("id",hasSize(greaterThan(100))).
                body("id",hasSize(lessThan(500))).
                body("[0].category.id",equalTo(0)).
                body("[0].photoUrls[0]",equalTo("string")).
                body("[0].tags[0].id",equalTo(0));
    }
}
