package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    1)Manual APi testlerimiz icin Postman kullanacagiz
2)Otomasyon tesleri icin Rest Assured Library kullanacagiz
3)Rest Assured ,Gherkin dilinden faydalanarak hazir methodlar olusturmustur
    a)given  : preconditions
    b)when   : get(), post() ,........
    c)then   : assertions(dogrulamalar) then kullanmak zorundayiz
    d)and    : coklu durumlari baglarken okunurluk acisindan kullanilabilir

4) API TESTLERİNİZİ YAZARKEN, AŞAĞIDAKİ ADIMLARI İZLEYEBİLİRSİNİZ:

   a) Set the url :
   API nin url ini ayarlayınız

   b) Set the expected data / payload :
      Beklenen datayi ayarlayinız

   c) Send the request and get the response :
      Request gönderilir ve response alınır

   d) Do assertions
      Response üzerinen dogrulamalar yaparız

      English
      /*
 given() : where we set up the details of our request
 when()  : This tells RestAssured, "Now send the request"
 get()   : HTTP GET method to request data from the server
 prettyPrint(): will print the response body to the console

     1. We use Postman for Manual tests of API
     2. We use Rest Assured Library for automation API
     3. To type automation script, follow these steps:
         a) we need to understand the requirement
         b) Write test scripts in Gherkin Language
               Gherkin Language has four keywords:
               i) Given: used for pre-conditions (url, authorisation, body, content type etc..)
               ii) When: used for action ( method name => get, post, put, delete etc..)
               iii) Then: used for assertions
               iv) And: used for repeating any step (multiple use of keywords)
         c) Start writing our Automation Script
             1. Set the URL
             2. Set the expected data
             3. Send the request and get the response
             4. Do assertion
 */


    @Test
    public void test01() {
        //1) Set the url :
        //   API nin url ini ayarlayınız
        String url = "https://petstore.swagger.io/v2/pet/320";

        //2) Set the expected data / payload :
        //      Beklenen datayi ayarlayinız


        //3) Send the request and get the response :
        //      Request gönderilir ve response alınır

        Response response = given().when().get(url);
        response.print(); // Prints body to console in one line
        response.prettyPrint(); // Prints body as response to console

        System.out.println("Status Code = " + response.statusCode());
        System.out.println("Status Line = " + response.statusLine());
        System.out.println("Response contentType = " + response.contentType());
        System.out.println("Response Time = " + response.time());
        System.out.println("Response Header = " + response.headers());
        System.out.println("Response Date: = " + response.header("Date"));
        System.out.println("Response Server: = " + response.header("Server"));

        //4) Do Assertions
        ///////////////////////

    }
}
