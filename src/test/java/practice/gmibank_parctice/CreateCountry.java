package practice.gmibank_parctice;

import baseUrl.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateCountry extends GMIBankBaseUrl {
    /*
Given
    https://gmibank.com/api/tp-countries
And
    {
        "id": null,
        "name": "Banana Republic",
        "states": [
            {
                "id": 0,
                "name": "Apple",
                "tpcountry": null
            },
            {
                "id": 1,
                "name": "Orange",
                "tpcountry": null
            },
            {
                "id": 2,
                "name": "Peach",
                "tpcountry": null
            }
        ]
    }
When
    Send POST request
Then
    Status code is 201
And
    Response body is like:
    {
        "id": 189865,
        "name": "Banana Republic",
        "states": [
            {
                "id": 0,
                "name": "Apple",
                "tpcountry": null
            },
            {
                "id": 1,
                "name": "Orange",
                "tpcountry": null
            },
            {
                "id": 2,
                "name": "Peach",
                "tpcountry": null
            }
        ]
    }
 */

    @Test
    public void testCreateCountry() {
        specification.pathParams("first","api","second","tp-countries");



        Response response = given(specification).body(payload).when().post("{first}/{second}");
    }
}
