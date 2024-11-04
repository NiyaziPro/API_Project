package regres_classwork;

import baseUrl.RegressBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.*;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeTest extends RegressBaseUrl {


/*
    Görev 2: Yeni Kullanıcı Oluşturma

    Amaç: Yeni bir kullanıcı oluşturma ve yanıtın doğruluğunu test etme.

    API Endpoint: POST https://reqres.in/api/users

    Body:

    {
    "name": "John",
    "job": "Developer"
}


    Response Body:
    {
    "name": "John",
    "job": "Developer",
    "id": "661",
    "createdAt": "2024-10-23T23:07:12.335Z"
}

    Test Adımları:
    Yeni bir kullanıcı oluşturmak için POST isteği gönder (örneğin, adı "John", işi "Developer").
    HTTP yanıt kodunun 201 olduğunu doğrula.
    Yanıtın JSON'da kullanıcının adının ve işinin doğru olduğunu kontrol et.

     */

    static String id;

    @Test(priority = 1)
    public void testCreateUser() {
        specification.pathParams("first", "api", "second", "users");

        RegresCreatePojo payload = new RegresCreatePojo("John","Developer");

        Response response = given(specification).body(payload).when().
                post("{first}/{second}");

        RegresGetPojo actualData = response.as(RegresGetPojo.class);

        assertEquals(201,response.statusCode());
        assertEquals(payload.getName(),actualData.getName());
        assertEquals(payload.getJob(),actualData.getJob());

        id = actualData.getId();
        System.out.println("id = " + id);
    }




    @Test(priority = 2)
    public void testGetUser() {

        specification.pathParams("first", "api", "second", "users","third",2);

        DataPojo data = new DataPojo(2,"janet.weaver@reqres.in","Janet","Weaver","https://reqres.in/img/faces/2-image.jpg");
        SupportPojo support = new SupportPojo("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");

        ResponsePojo payload = new ResponsePojo(data,support);

        Response response = given(specification).when().
                get("{first}/{second}/{third}");

        ResponsePojo actualData = response.as(ResponsePojo.class);

        System.out.println(actualData);

    }
}
