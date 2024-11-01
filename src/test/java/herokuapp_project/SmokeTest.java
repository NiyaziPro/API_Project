package herokuapp_project;


import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.HerokuAppBookingDatesPojo;
import pojos.HerokuAppGetResponsePojo;
import pojos.HerokuAppPostResponsePojo;
import utilities.AuthenticateHerokuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeTest extends HerokuAppBaseUrl {
    /*
Given
https://restful-booker.herokuapp.com/booking
And
	{
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
When
	Send post request
Then
	Status code is 200
And
	Body:
	 {
		"bookingid": 1,
    		"booking": {
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
}

*/

    static int bookingId;

    @Test(priority = 1)
    public void createBooking() {
        // Set the url
        specification.pathParam("first", "booking");

        // Set the expected data / payload
        HerokuAppBookingDatesPojo bookingdates = new HerokuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerokuAppGetResponsePojo payload = new HerokuAppGetResponsePojo("Jim", "Brown", 111, true, bookingdates, "Breakfast");

        // Send request get response
        Response response = given(specification).body(payload).when().post("{first}");

        // Do Assertion
        HerokuAppPostResponsePojo actualData = response.as(HerokuAppPostResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(payload.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(payload.getLastname(), actualData.getBooking().getLastname());
        assertEquals(payload.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(payload.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(payload.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(payload.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(payload.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

        ///extra
        assertEquals(bookingdates.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());

        //1.yol
//       int bookingId = response.jsonPath().getInt("bookingid");

        //2.yol tavsiye edilen
        bookingId = actualData.getBookingid();

    }

    @Test(priority = 2)
    public void getBooking() {

        /*
        Given
        https://restful-booker.herokuapp.com/booking/:id
        When
        Send get request
        Then
        Status code is 200
        And
        Body:
        {
		"bookingid": 1,
    		"booking": {
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

        //set the url
        specification.pathParams("first", "booking", "second", bookingId);

        //set the expected data / payload
        HerokuAppBookingDatesPojo bookingDatesPojo = new HerokuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerokuAppGetResponsePojo expectedData
                = new HerokuAppGetResponsePojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        //send request get response
        Response response = given(specification).when().get("{first}/{second}");

        //do assertion
        HerokuAppGetResponsePojo actualData = response.as(HerokuAppGetResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

    }


    /*
Given
https://restful-booker.herokuapp.com/booking/:id
And
   {
"firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}

When
	Send put request
Then
	Status code is 200
And
	Body:
{
"firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}

*/


    @Test(priority = 3)
    public void updateBooking() {

        //set the url
        specification.pathParams("first", "booking", "second", bookingId);

        //set the expected data / payload
        HerokuAppBookingDatesPojo bookingDatesPojo = new HerokuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerokuAppGetResponsePojo payload
                = new HerokuAppGetResponsePojo("James", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        // send request get response
        Response response = given(specification).body(payload).when().put("{first}/{second}");

        //do assertion
        HerokuAppGetResponsePojo actualData = response.as(HerokuAppGetResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(payload.getFirstname(), actualData.getFirstname());
        assertEquals(payload.getLastname(), actualData.getLastname());
        assertEquals(payload.getTotalprice(), actualData.getTotalprice());
        assertEquals(payload.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(payload.getAdditionalneeds(), actualData.getAdditionalneeds());

    }

    /*
Given
https://restful-booker.herokuapp.com/booking/:id
And
	{
"firstname" : "Ali",
    "lastname" : "Can"
	}
When
	Send patch request
Then
	Status code is 200
And
	Body:
	{
	"firstname" : "Ali",
     "lastname" : "Can",
     "totalprice" : 111,
     "depositpaid" : true,
     "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
*/


    @Test(priority = 4)
    public void partiallyUpdate() {

        //set the url
        specification.pathParams("first", "booking", "second", bookingId);

        //set the expected data / payload
        Map<String, String> payload = new HashMap<>();
        payload.put("firstname", "Ali");
        payload.put("lastname", "Can");

        //send request get response
        Response response = given(specification).body(payload).when().patch("{first}/{second}");

        //do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.get("firstname"), actualData.get("firstname"));
        assertEquals(payload.get("lastname"), actualData.get("lastname"));

    }

    /*
    Given
    https://restful-booker.herokuapp.com/booking/1
    When
        Send delete request
    Then
        Status code is 201
    And
        Body should be : “Created”

*/

    @Test(priority = 5)
    public void deleteBooking() {

        //set the url
        specification.pathParams("first", "booking", "second", bookingId);

        //set the expected data / payload
        //        String expectedData = "Created";

        //send request get response
        Response response = given(specification).when().delete("{first}/{second}");
        //response.prettyPrint();

        //do assertion
        response.then()
                .statusCode(201)
                .body(containsString("Created"));

    }


    /*
Given
   https://restful-booker.herokuapp.com/booking/:id
When
    Send get request
Then
    Status code is 404
And
    Body is "Not Found"
 */


    @Test(priority = 6)
    public void negativeScenario() {

        //set the url
        specification.pathParams("first", "booking", "second", bookingId);

        //set the expected data / payload
        String expectedData = "Not Found";

        //send request get response
        Response response = given(specification).when().get("{first}/{second}");

        // do assertion
        assertEquals(404, response.statusCode());
        assertEquals(expectedData, response.asString());

    }

}
