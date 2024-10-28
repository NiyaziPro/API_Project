package get_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get09 extends JsonPlaceHolderBaseUrl {
    /*
    Given
       https://jsonplaceholder.typicode.com/todos
    When
       Kullanıcı URL'e bir GET request gönderir
    Then
        Status code 200 olmalı
        "Id"leri 190 dan büyük olanları konsola yazdırın
        "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
 */

    @Test
    public void test01() {
        //1. Set the URL
        specification.pathParam("first", "todos");

        //2.Set the expected data / payload :
        //3. Send request get response:

        Response response = given(specification).when().get("{first}");

        //response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        List<Object> id = jsonPath.getList("id");
        //System.out.println("id = " + id);
        //System.out.println("id.size() = " + id.size());

        List<Object> title = jsonPath.getList("title");
        //System.out.println("title = " + title);

        List<Object> completed = jsonPath.getList("completed");
        //System.out.println("completed = " + completed);

        System.out.println("======================================");

        //4. Do Assertion

        assertEquals(200, response.statusCode());

        //"Id"leri 190 dan büyük olanları konsola yazdırın
        List<Object> jsonList = jsonPath.getList("findAll{it.id > 190}");
        System.out.println("list = " + jsonList);
        System.out.println("======================================");
        //"Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        assertEquals(10, jsonList.size());

        //"Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        List<Integer> jsonList02 = jsonPath.getList("findAll{it.id < 5}.userId");
        System.out.println("jsonList02 = " + jsonList02);

        //"Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        assertEquals(4, jsonList02.size());

        //"Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        List<String> jsonList03 = jsonPath.getList("findAll{it.id < 5}.title");
        System.out.println("jsonList03 = " + jsonList03);


        // "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
        int userId = jsonPath.getInt("findAll{it.title =='delectus aut autem'}[0].userId");
        assertTrue(userId < 5);

        assertTrue(jsonList03.contains("delectus aut autem"));


    }
}
