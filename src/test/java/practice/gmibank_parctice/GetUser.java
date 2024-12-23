package practice.gmibank_parctice;

import baseUrl.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import practice.gmibank_parctice.pojos.CountryPojo;
import practice.gmibank_parctice.pojos.ResponseGMIBankPojo;
import practice.gmibank_parctice.pojos.UserPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GetUser extends GMIBankBaseUrl {
 /*
            Given
              https://www.gmibank.com/api/tp-customers/110457
           When
             I send GET Request to the URL
          Then
             Status code is 200
             And response body is like {
            "id": 110457,
            "firstName": "Jeremy",
            "lastName": "O'Reilly",
            "middleInitial": "A",
            "email": "lane.kreiger@hotmail.com",
            "mobilePhoneNumber": "208-961-1605",
            "phoneNumber": "208-961-1605",
            "zipCode": "56163",
            "address": "96922 Schumm Port, North Emmitt, KS 04003",
            "city": "Port Morgan",
            "ssn": "704-72-7293",
            "createDate": "2021-11-28T21:00:00Z",
            "zelleEnrolled": false,
            "country": {
                "id": 24105,
                "name": "San Jose",
                "states": null
            },
            "state": "",
            "user": {
                "id": 110022,
                "login": "courtney.aufderhar",
                "firstName": "Jeremy",
                "lastName": "O'Reilly",
                "email": "lane.kreiger@hotmail.com",
                "activated": true,
                "langKey": "en",
                "imageUrl": null,
                "resetDate": null
            },`
        "accounts": []
              }
     */


    @Test
    public void testGetRequestGMIBank() {

        specification.pathParams("first", "api", "second", "tp-customers", "third", 110457);

        Response response = given(specification).when().get("{first}/{second}/{third}");

        CountryPojo country = new CountryPojo(24105, "San Jose", null);
        UserPojo user = new UserPojo(110022, "courtney.aufderhar", "Jeremy", "O'Reilly", "lane.kreiger@hotmail.com", true, "en", null, null);

        List<Object> accounts = new ArrayList<>();

        ResponseGMIBankPojo expectedData = new ResponseGMIBankPojo(110457, "Jeremy", "O'Reilly", "A", "lane.kreiger@hotmail.com",
                "208-961-1605", "208-961-1605", "56163", "96922 Schumm Port, North Emmitt, KS 04003",
                "Port Morgan", "704-72-7293", "2021-11-28T21:00:00Z", false, country, "", user, accounts);

        ResponseGMIBankPojo actualData = response.as(ResponseGMIBankPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(), actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(), actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(), actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(), actualData.getZipCode());
        assertEquals(expectedData.getAddress(), actualData.getAddress());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getSsn(), actualData.getSsn());
        assertEquals(expectedData.getCreateDate(), actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(), actualData.isZelleEnrolled());

        assertEquals(expectedData.getCountry().getId(), actualData.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(), actualData.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(), actualData.getCountry().getStates());

        assertEquals(expectedData.getState(), actualData.getState());

        assertEquals(expectedData.getUser().getId(), actualData.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(), actualData.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(), actualData.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(), actualData.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(), actualData.getUser().getEmail());
        assertEquals(expectedData.getUser().isActivated(), actualData.getUser().isActivated());
        assertEquals(expectedData.getUser().getLangKey(), actualData.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(), actualData.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(), actualData.getUser().getResetDate());


    }
}
