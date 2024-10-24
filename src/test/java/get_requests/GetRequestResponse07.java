package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class GetRequestResponse07 extends HerokuAppBaseUrl {
    
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

    /* JSON PATH  usage*/

    @Test
    public void testJsonPath() {

        specification.pathParams("first", "booking", "second", 654);

        Response response = given(specification).when().
                get("{first}/{second}");

        //response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        System.out.println("jsonPath.toString() = " + jsonPath.toString());
        String firstname = jsonPath.getString("firstname");
        System.out.println("firstname = " + firstname);

        boolean depositpaid = jsonPath.getBoolean("depositpaid");
        System.out.println("depositpaid = " + depositpaid);

        Object object = jsonPath.getJsonObject("bookingdates");
        System.out.println("Chekin = " + jsonPath.getString("bookingdates.checkin"));

        assertEquals("Jim",jsonPath.getString("firstname"));
        assertEquals("Brown",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals("Breakfast",jsonPath.getString("additionalneeds"));


    }
}
