package regres_classwork;

import baseUrl.RegressBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.RegresCreatePojo;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeTest extends RegressBaseUrl {


    @Test
    public void testCreate() {
        specification.pathParams("first", "api", "second", "users");

        RegresCreatePojo payload = new RegresCreatePojo("morpheus","leader");

        Response response = given(specification).body(payload).when().
                post("{first}/{second}");

        RegresCreatePojo actualData = response.as(RegresCreatePojo.class);

        assertEquals(201,response.statusCode());
        assertEquals(payload.getName(),actualData.getName());
        assertEquals(payload.getJob(),actualData.getJob());
    }


}
