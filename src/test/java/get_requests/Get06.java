package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get06 extends HerokuAppBaseUrl {
    
    /*
    Given
        https://restful-booker.herokuapp.com/apidoc/index.html
        https://restful-booker.herokuapp.com/booking/994
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type should contain "application/json"
    And
        Response body should be like;
            {
                "firstname": "Jim",
                "lastname": "Brown",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
 */

    @Test
    public void test01() {

        specification.pathParams("first", "booking", "second", 994);

        Response response = given(specification).when().
                get("{first}/{second}");

        response.prettyPrint();

        response.then().statusCode(200).
                contentType(ContentType.JSON.toString()).
                body("firstname", equalTo("John")).
                body("lastname", equalTo("Smith")).
                body("totalprice", equalTo(111)).
                body("depositpaid", equalTo(true)).
                body("bookingdates.checkin", equalTo("2018-01-01")).
                body("bookingdates.checkout", equalTo("2019-01-01")).
                body("additionalneeds", equalTo("Breakfast"));

    }
}
