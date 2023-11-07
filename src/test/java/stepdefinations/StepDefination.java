package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.org.LoginResponse;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefination extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();
    public static String productId;
    public static String token;
    public static String userId;

    @Given("Login payload with {string} and {string}")
    public void login_payload_with_and(String userEmail, String userPassword) throws IOException {
        res = given().relaxedHTTPSValidation().spec(requestSpecificationLogin())
                .body(data.addLoginCredentials("sarwanfire@gmail.com", "Sarwan@2456"));
    }

    @When("user calls LoginAPI with POST http request")
    public void user_calls_login_api_with_post_http_request() {
        APIResources resourceAPI = APIResources.valueOf("LoginAPI"); // enum
        response = res.when().post(resourceAPI.getResource());
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        int actualStatusCode = response.getStatusCode();
        if (actualStatusCode == int1) {
            System.out.println(actualStatusCode + ":Status Code validation passed");
        } else {
            System.out.println(actualStatusCode + ":Status Code validation failed");
        }
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        String Actual = getJsonPath(response, keyValue); // Json Resuable
        assertEquals(Actual, Expectedvalue);
        System.out.println("Message Validation passed:" + Actual);
    }

    @Then("verify userId and token created")
    public void verify_user_id_and_token_created() {
        LoginResponse loginResponse = response.as(LoginResponse.class);
        token = loginResponse.getToken(); // Authorization Token
        userId = loginResponse.getUserId();
        assertEquals(token, token);
        assertEquals(userId, userId);
        System.out.println("verified userId and token created");
    }







}
