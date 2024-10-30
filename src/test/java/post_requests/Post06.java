package post_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.HerokuAppBookingDatesPojo;
import pojos.HerokuAppGetResponsePojo;
import pojos.HerokuAppPostResponsePojo;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post06 extends HerokuAppBaseUrl {

    /*
    Given
      1)  https://restful-booker.herokuapp.com/booking
      2) {
            "firstname": "Ali",
            "lastname": "Can",
            "totalprice": 999,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-21",
                "checkout": "2021-12-21"
             },
             "additionalneeds": "Breakfast"
          }
    When
        I send POST Request to the URL
    Then
        Status code is 200
    And
        Response body is like
             {
                "bookingid": 16,
                "booking" :{
                    "firstname": "Ali",
                    "lastname": "Can",
                    "totalprice": 999,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2021-09-21",
                        "checkout": "2021-12-21"
                    },
                    "additionalneeds": "Breakfast"
                 }
              }
 */


    @Test
    public void test01() {
        specification.pathParam("first", "booking");

        HerokuAppBookingDatesPojo bookingdates = new HerokuAppBookingDatesPojo("2021-09-21", "2021-12-21");
        HerokuAppGetResponsePojo payload = new HerokuAppGetResponsePojo("Ali", "Can", 999, true, bookingdates, "Breakfast");

        Response response = given(specification).body(payload).when().post("{first}");

        HerokuAppPostResponsePojo actualData = response.as(HerokuAppPostResponsePojo.class);

        response.then().statusCode(200);
        assertEquals(payload.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(payload.getLastname(),actualData.getBooking().getLastname());
        assertEquals(payload.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(payload.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(payload.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(payload.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(payload.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());


        System.out.println("actualData.getBookingid() = " + actualData.getBookingid());





    }

    @Test
    public void testSoftAssertion() {
        specification.pathParam("first", "booking");

        HerokuAppBookingDatesPojo bookingdates = new HerokuAppBookingDatesPojo("2021-09-21", "2021-12-21");
        HerokuAppGetResponsePojo payload = new HerokuAppGetResponsePojo("Ali", "Can", 999, true, bookingdates, "Breakfast");

        Response response = given(specification).body(payload).when().post("{first}");

        HerokuAppPostResponsePojo actualData = response.as(HerokuAppPostResponsePojo.class);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(actualData.getBooking().getFirstname(),payload.getFirstname());
        softAssert.assertEquals(actualData.getBooking().getLastname(),payload.getLastname());
        softAssert.assertEquals(actualData.getBooking().getTotalprice(),payload.getTotalprice());
        softAssert.assertEquals(actualData.getBooking().getDepositpaid(),payload.getDepositpaid());
        softAssert.assertEquals(actualData.getBooking().getBookingdates().getCheckin(),payload.getBookingdates().getCheckin());
        softAssert.assertEquals(actualData.getBooking().getBookingdates().getCheckout(),payload.getBookingdates().getCheckout());
        softAssert.assertEquals(actualData.getBooking().getAdditionalneeds(),payload.getAdditionalneeds());

        softAssert.assertAll();






    }
}
