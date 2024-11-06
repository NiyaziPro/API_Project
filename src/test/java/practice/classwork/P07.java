package practice.classwork;

import baseUrl.RegressBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.RegresCreatePojo;
import pojos.RegresGetPojo;
import practice.test_data.RegressTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static practice.test_data.RegressTestData.regresDataMapper;

public class P07 extends RegressBaseUrl {
     /*
    Given
        1) https://reqres.in/api/users
        2) {
            "name": "morpheus",
            "job": "leader"
            }
    When
        I send POST Request to the Url
    Then
        Status code is 201
        And response body should be like
         {
              "name": "morpheus",
              "job": "leader",
              "id": "496",
              "createdAt": "2022-11-22T06:40:22.293Z"
            }
 */

    @Test
    public void test01() {
        specification.pathParams("first", "api", "second", "users");

        RegresCreatePojo payload = new RegresCreatePojo("morpheus","leader");

        Response response = given(specification).body(payload).when().
                post("{first}/{second}");

        RegresGetPojo actualData = response.as(RegresGetPojo.class);

        assertEquals(201,response.statusCode());
        assertEquals(payload.getName(),actualData.getName());
        assertEquals(payload.getJob(),actualData.getJob());


    }

    @Test
    public void test02() {
        specification.pathParams("first", "api", "second", "users");

        Map<String, Object> payload = regresDataMapper("morpheus", "leader", null, null);
        System.out.println("payload = " + payload);

        Response response = given(specification).body(payload).when().post("{first}/{second}");

        response.prettyPrint();

        Map<String,Object> actualData = response.as(HashMap.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(),201);
        softAssert.assertEquals(actualData.get("name"),payload.get("name"));
        softAssert.assertEquals(actualData.get("job"),payload.get("job"));

        softAssert.assertAll();

    }
}
