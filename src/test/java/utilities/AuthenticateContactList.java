package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateContactList {

    public static String generateToken() {
        String url = "https://thinking-tester-contact-list.herokuapp.com/users/login";

        // 2. Set the Expected data/ payload
        String payload = "{\n" +
                "    \"email\": \"nyztester@mail.com\",\n" +
                "    \"password\": \"NyzTester123#\"\n" +
                "}";

        // 3. Send Request get response

        Response response = given().
                                    body(payload).
                                    contentType(ContentType.JSON).
                                    when().
                                    post(url);

        return response.jsonPath().getString("token");

    }
}
