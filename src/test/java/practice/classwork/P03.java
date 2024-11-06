package practice.classwork;

import baseUrl.RegressBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class P03 extends RegressBaseUrl {

    /*
   Given
       https://reqres.in/api/users/2
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
*/

    @Test
    public void testGetRequestResponse() {
        specification.pathParams("first", "api", "second", "users","third",2);

        Response response = given(specification).when().get("{first}/{second}/{third}");


        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email",equalTo("janet.weaver@reqres.in"),
                        "data.first_name",equalTo("Janet"),
                        "data.last_name",equalTo("Weaver"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JsonPath actualData = response.jsonPath();

        assertEquals(200,response.statusCode());
        assertEquals("application/json; charset=utf-8",response.getContentType());
        assertEquals("janet.weaver@reqres.in",actualData.getString("data.email"));
        assertEquals("Janet",actualData.get("data.first_name"));
        assertEquals("Weaver",actualData.get("data.last_name"));
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",actualData.get("support.text"));

    }
}
