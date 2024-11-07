package practice.gmibank_parctice;

import baseUrl.GMIBankBaseUrl;
import groovy.json.JsonGenerator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import practice.gmibank_parctice.pojos.CountryPojo;
import practice.gmibank_parctice.pojos.StatePojo;

import java.util.ArrayList;
import java.util.List;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

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

        StatePojo state1 = new StatePojo(0,"Apple",null);
        StatePojo state2 = new StatePojo(1,"Orange",null);
        StatePojo state3 = new StatePojo(2,"Peach",null);

        List<StatePojo> states = new ArrayList<>();
        states.add(state1);
        states.add(state2);
        states.add(state3);

        CountryPojo payload = new CountryPojo(null,"Banana Republic",states);
        //System.out.println("payload = " + payload);


        Response response = given(specification).body(payload).when().post("{first}/{second}");

        response.prettyPrint();

        CountryPojo actualData = convertJsonToJava(response.asString(), CountryPojo.class);

        response.then().statusCode(201);

        assertEquals(payload.getName(), actualData.getName());
        assertEquals(payload.getStates().get(0).getId(), actualData.getStates().get(0).getId());
        assertEquals(payload.getStates().get(0).getName(), actualData.getStates().get(0).getName());
        assertEquals(payload.getStates().get(0).getTpcountry(), actualData.getStates().get(0).getTpcountry());

        assertEquals(payload.getStates().get(1).getId(), actualData.getStates().get(1).getId());
        assertEquals(payload.getStates().get(1).getName(), actualData.getStates().get(1).getName());
        assertEquals(payload.getStates().get(1).getTpcountry(), actualData.getStates().get(1).getTpcountry());

        assertEquals(payload.getStates().get(2).getId(), actualData.getStates().get(2).getId());
        assertEquals(payload.getStates().get(2).getName(), actualData.getStates().get(2).getName());
        assertEquals(payload.getStates().get(2).getTpcountry(), actualData.getStates().get(2).getTpcountry());

    }
}
