package practice.classwork;

import baseUrl.RegressBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.RegresDataPojo;
import pojos.RegresResponsePojo;
import pojos.RegresSupportPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P04 extends RegressBaseUrl {


    @Test
    public void test01() {

        specification.pathParams("first", "api", "second", "users", "third", 2);

        RegresDataPojo data = new RegresDataPojo(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        RegresSupportPojo support = new RegresSupportPojo("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");

        RegresResponsePojo expectedData = new RegresResponsePojo(data, support);

        Response response = given(specification).when().
                get("{first}/{second}/{third}");

        RegresResponsePojo actualData = response.as(RegresResponsePojo.class);

        ////////////////////////// Data /////////////////////////////////
        assertEquals(expectedData.getData().getEmail(), actualData.getData().getEmail());
        assertEquals(expectedData.getData().getFirst_name(), actualData.getData().getFirst_name());
        assertEquals(expectedData.getData().getLast_name(), actualData.getData().getLast_name());
        assertEquals(expectedData.getData().getAvatar(), actualData.getData().getAvatar());

        /////////////////////// Support /////////////////////////////////
        assertEquals(expectedData.getSupport().getText(), actualData.getSupport().getText());
        assertEquals(expectedData.getSupport().getUrl(), actualData.getSupport().getUrl());


    }
}
