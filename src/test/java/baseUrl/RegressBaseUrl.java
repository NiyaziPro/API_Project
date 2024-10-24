package baseUrl;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class RegressBaseUrl {
    /*
AMAÇ :
==> Her testten önce çalışarak base url ve content type gibi ortak request yapılandırmalarını tek merkezden
bie defa yapmak, böylece testlerin bakımının daha kolay olmasını sağlamak
==> kod tekrarını önlemek
     */
    // This class is created to prevent repetition of pre-conditions (urls, content-type, header, token etc..)

    protected RequestSpecification specification;

    @BeforeMethod  // This annotation will run before each test method
    public void setUp() {

        String baseUrl = "https://reqres.in";
        specification = new RequestSpecBuilder().
                setBaseUri(baseUrl).
                setContentType(ContentType.JSON).
                build();
    }
}
