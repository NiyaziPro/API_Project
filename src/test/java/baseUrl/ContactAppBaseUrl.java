package baseUrl;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import utilities.AuthenticateContactList;

import static utilities.AuthenticateContactList.generateToken;

public class ContactAppBaseUrl {
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

        String baseUrl = "https://thinking-tester-contact-list.herokuapp.com";
        specification = new RequestSpecBuilder().
                setBaseUri(baseUrl).
                addHeader("Authorization", AuthenticateContactList.generateToken()).
                setContentType(ContentType.JSON).
                build();
    }
}
