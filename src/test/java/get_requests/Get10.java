package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get10 extends HerokuAppBaseUrl {

    /*
Given
    https://restful-booker.herokuapp.com/booking/2385
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
        "additionalneeds": "Dinner"
    }
*/


    @Test
    public void test01() {

        // Set the url
        specification.pathParams("first","booking","second","1444");

        // Set the expected data / payload
        Map<String,String> bookingdates = new HashMap<>();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        Map<String,Object> payload = new HashMap<>();
        payload.put("firstname","John");
        payload.put("lastname","Smith");
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingdates);
        payload.put("additionalneeds","Dinner");

        // Send request get response:

        Response response = given(specification).body(payload).when().get("{first}/{second}");
        JsonPath jsonPath = response.jsonPath();
        //Map<String,Object> actualData = response.as(HashMap.class);
        response.then().statusCode(200);

        assertEquals(payload.get("firstname"),jsonPath.getString("firstname"));
        assertEquals(payload.get("lastname"),jsonPath.getString("lastname"));
        assertEquals(payload.get("totalprice"),jsonPath.getInt("totalprice"));
        assertEquals(payload.get("depositpaid"),jsonPath.getBoolean("depositpaid"));
        assertEquals(payload.get("additionalneeds"),jsonPath.getString("additionalneeds"));
        assertEquals(bookingdates.get("checkin"),jsonPath.getString("bookingdates.checkin"));
        assertEquals(bookingdates.get("checkout"),jsonPath.getString("bookingdates.checkout"));

        /////////////////////////////////////////////////////////////////////////////////////
        /*assertEquals(payload.get("firstname"),actualData.get("firstname"));
        assertEquals(payload.get("lastname"),actualData.get("lastname"));
        assertEquals(payload.get("totalprice"),actualData.get("totalprice"));
        assertEquals(payload.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(payload.get("additionalneeds"),actualData.get("additionalneeds"));
*/



    }
}
