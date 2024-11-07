package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateGMIBank {
    public static String generateToken() {
        String url = "https://gmibank.com/api/authenticate";

        // 2. Set the Expected data/ payload
        String payload = "{\n" +
                "  \"password\": \"Mark.123\",\n" +
                "  \"rememberMe\": true,\n" +
                "  \"username\": \"mark_twain\"\n" +
                "}";

        // 3. Send Request get response

        Response response = given().
                body(payload).
                contentType(ContentType.JSON).
                when().
                post(url);

        return response.jsonPath().getString("id_token");

    }

}
