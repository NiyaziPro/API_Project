package practice.classwork;

import baseUrl.HerokuAppBaseUrl;
import baseUrl.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class P05 extends HerokuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

*/

    @Test
    public void test01() {

        specification.pathParam("first","booking").queryParams("firstname","Brandon","lastname","Wilson");

        Response response = given(specification).
                when().
                get("{first}");
        response.
        then().statusCode(200);
                //body("booking.bookingid",equalTo(1392));




    }
}
