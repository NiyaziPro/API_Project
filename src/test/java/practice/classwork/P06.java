package practice.classwork;

import baseUrl.RegressBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P06 extends RegressBaseUrl {
    /*
     Given
            https://reqres.in/api/unknown/
     When
          I send GET Request to the URL
     Then

          1)Status code is 200
          2)Print all pantone_values
          3)Print all ids greater than 3 on the console
            Assert that there are 3 ids greater than 3
          4)Print all names whose ids are less than 3 on the console
            Assert that the number of names whose ids are less than 3 is 2
  */

    @Test
    public void test01() {
        specification.pathParams("first","api","second","unknown");

        Response response = given(specification).when().get("{first}/{second}");
        //response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        // 2)Print all pantone_values
        List<String> pantoneValues = jsonPath.getList( "data.pantone_value");
        System.out.println(pantoneValues);

        // 3)Print all ids greater than 3 on the console
        //            Assert that there are 3 ids greater than 3

        // Tüm id değerlerini liste olarak al findAll{it.id < 5}.userId
        List<Integer> idsGreaterThree = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("idsGreaterThree = " + idsGreaterThree);

        assertEquals(3,idsGreaterThree.size());

        //4)Print all names whose ids are less than 3 on the console
        //            Assert that the number of names whose ids are less than 3 is 2

        List<String> namesWithIdsLessThanThree = jsonPath.getList("data.findAll { it.id < 3 }.name");

        System.out.println("Names with IDs less than 3: " + namesWithIdsLessThanThree);

        assertEquals(2,namesWithIdsLessThanThree.size());
    }
}
