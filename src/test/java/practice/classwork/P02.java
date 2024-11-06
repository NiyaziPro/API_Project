package practice.classwork;

import baseUrl.RegressBaseUrl;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class P02 extends RegressBaseUrl {

    /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Server is "cloudflare"
   And
       Response body should be empty

*/

    @Test
    public void testGetRequestRegressIn() {

        specification.pathParams("first", "api", "second", "users","third",23);

        given(specification).when()
                .get("{first}/{second}/{third}")
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","cloudflare")
                .body(equalTo("{}"))
                .body("isEmpty()",is(true));
    }
}
