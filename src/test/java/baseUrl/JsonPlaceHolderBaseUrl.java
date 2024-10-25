package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification specification;

    @BeforeMethod
    public void setUp() {

        String baseUrl = "https://jsonplaceholder.typicode.com";
        specification = new RequestSpecBuilder().
                setBaseUri(baseUrl).
                setContentType(ContentType.JSON).
                build();
    }
}
