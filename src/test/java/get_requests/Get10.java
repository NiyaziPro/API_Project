package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
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
        specification.pathParams("first", "booking", "second", 3175);

        // Set the expected data / payload
        //INNER MAP
        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        //OUTER MAP
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", "John");
        payload.put("lastname", "Smith");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingdates);
        payload.put("additionalneeds", "Dinner");

        // Send request get response:

        Response response = given(specification).when().get("{first}/{second}");
        JsonPath jsonPath = response.jsonPath();
        Map<String, Object> actualData = response.as(HashMap.class);


        assertEquals(payload.get("firstname"), actualData.get("firstname"));
        assertEquals(payload.get("lastname"), actualData.get("lastname"));
        assertEquals(payload.get("totalprice"), actualData.get("totalprice"));
        assertEquals(payload.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(payload.get("additionalneeds"), actualData.get("additionalneeds"));
        assertEquals(bookingdates.get("checkin"), jsonPath.getString("bookingdates.checkin"));
        assertEquals(bookingdates.get("checkout"), jsonPath.getString("bookingdates.checkout"));


    }

    @Test
    public void test02() {
        //1- set the url
        specification.pathParams("first", "booking", "second", 4264);

        // 2- set the expected data / payload

        //INNER MAP i oluşturduk
        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        //OUTER MAP
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdates);
        expectedData.put("additionalneeds", "Dinner");
        System.out.println("expectedData = " + expectedData);

        //3- send request get response
        Response response = given(specification)
                .when()
                .get("{first}/{second}");

        //4- do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        Assert.assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
        Assert.assertEquals(expectedData.get("bookingdates"), actualData.get("bookingdates"));


        Object object = ((Map) actualData.get("bookingdates"));

//       Object object = (  (Map) actualData.get("bookingdates")  ).get("checkin");
//       System.out.println("object = " + object);

        //1.yol Map ile doğrulama ===> tavsiye edilmez
        Assert.assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
        Assert.assertEquals(((Map) actualData.get("bookingdates")).get("checkin"), bookingdates.get("checkin"));
        Assert.assertEquals(((Map) actualData.get("bookingdates")).get("checkout"), bookingdates.get("checkout"));


        //2.yol Json path ile doğrulama ==> nested datalar ile çalışırken tavsiye edilir
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("bookingdates.checkin"), bookingdates.get("checkin"));
        Assert.assertEquals(jsonPath.getString("bookingdates.checkout"), bookingdates.get("checkout"));


    }

}
