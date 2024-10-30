package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.HerokuAppBookingDatesPojo;
import pojos.HerokuAppGetResponsePojo;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get11 extends HerokuAppBaseUrl {

     /*
Given
    https://restful-booker.herokuapp.com/booking/722
When
    I send GET Request to the url
Then
    Response body should be like that;
    {
        "firstname": "John",
        "lastname": "Smith",
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
        //1- set the url
        specification.pathParams("first", "booking", "second", 2198);

        // 2- set the expected data / payload
        HerokuAppBookingDatesPojo bookingdates = new HerokuAppBookingDatesPojo("2018-01-01","2019-01-01");

        HerokuAppGetResponsePojo expectedData = new HerokuAppGetResponsePojo("John","Smith",111,true,bookingdates,"Breakfast");

        // 3 - Send Request

        Response response = given(specification).when().get("{first}/{second}");

        // 4 - Do Assertion
        HerokuAppGetResponsePojo actualData = response.as(HerokuAppGetResponsePojo.class);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
    }
}
