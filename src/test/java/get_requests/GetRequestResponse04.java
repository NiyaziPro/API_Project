package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequestResponse04 extends PetStoreBaseUrl {

    /*
    Given
        https://petstore.swagger.io/v2/pet/7777
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
*/

    @Test
    public void test01() {

        specification.pathParams("p1","pet","p2",7777);

        given(specification).when().
                get("/{p1}/{p2}").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                log().
                all();
    }
}
