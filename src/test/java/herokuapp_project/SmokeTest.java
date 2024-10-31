package herokuapp_project;


import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.HerokuAppBookingDatesPojo;
import pojos.HerokuAppGetResponsePojo;
import pojos.HerokuAppPostResponsePojo;
import utilities.AuthenticateHerokuApp;

import static io.restassured.RestAssured.given;
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


    @Test
    public void createBooking() {
        // Set the url
        specification.pathParam("first","booking");

        // Set the expected data / payload
        HerokuAppBookingDatesPojo bookingdates = new HerokuAppBookingDatesPojo("2018-01-01","2019-01-01");
        HerokuAppGetResponsePojo  payload = new HerokuAppGetResponsePojo("Jim","Brown", 111,true,bookingdates,"Breakfast");

        // Send request get response
        Response response = given(specification).body(payload).when().post("{first}");

        // Do Assertion
        HerokuAppPostResponsePojo actualData = response.as(HerokuAppPostResponsePojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(payload.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(payload.getLastname(),actualData.getBooking().getLastname());
        assertEquals(payload.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(payload.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(payload.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(payload.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(payload.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

        ///extra
        assertEquals(bookingdates.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());


    }
}
