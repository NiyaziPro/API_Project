package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateHerokuApp {

    public static String generateToken() {
        String url = "https://restful-booker.herokuapp.com/auth";

        // 2. Set the Expected data/ payload
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // 3. Send Request get response

        Response response = given().
                body(payload).
                contentType(ContentType.JSON).
                when().
                post(url);

        return response.jsonPath().getString("token");

    }
    public static String generateToken(String url, String payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(url)
                .jsonPath()
                .getString("token");
    }
}
