package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import utilities.AuthenticateGMIBank;


public class GMIBankBaseUrl {
    protected RequestSpecification specification;

    @BeforeMethod
    public void setUp() {

        String baseUrl = "https://www.gmibank.com";
        specification = new RequestSpecBuilder().
                setBaseUri(baseUrl).
                addHeader("Authorization", "Bearer " + AuthenticateGMIBank.generateToken()).
                setContentType(ContentType.JSON).
                build();
    }
}
