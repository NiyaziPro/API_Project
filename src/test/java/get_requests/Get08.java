package get_requests;

import baseUrl.ContactAppBaseUrl;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get08 extends ContactAppBaseUrl {

     /*
   Given
       https://thinking-tester-contact-list.herokuapp.com/contacts
   When
       Kullanıcı URL'e bir GET request gönderir
   Then
       HTTP Status Code 200 olmalı
   And
       Content Type "application/json" olmalı
*/


    @Test
    public void testGetRequest01() {
        // 1.set the url
        specification.pathParam("first","contacts");

        // 2.Set the expected data / payland :
        // 3. Send the request and get the response :
        // 4.Do Assertion
        given(specification).
                when().
                get("{first}").
                then().statusCode(200).contentType(ContentType.JSON).log().all();


    }


}
