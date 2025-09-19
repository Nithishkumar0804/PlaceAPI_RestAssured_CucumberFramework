package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Utils.SpecBuildersUtils;
import resources.payloads.TestDataBuilder;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PlaceApiStepDefinition extends SpecBuildersUtils {
    RequestSpecification req;
    Response response;
    static String placeId;
    TestDataBuilder data = new TestDataBuilder();

    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_name_address_language(String name, String address, String language) throws IOException {

        req = given().spec(requestSpecification()).body(data.addPlacePayload(name, address, language));

    }

    @When("user calls {string} with request {string}")
    public void user_calls_with_post(String resources, String httpMethod) {
        if (httpMethod.equalsIgnoreCase("Post")) {
            response = req.when().post(APIResources.valueOf(resources).getResources()).then().extract().response();
        } else if (httpMethod.equalsIgnoreCase("Get")) {
            response = req.when().get(APIResources.valueOf(resources).getResources()).then().extract().response();
        } else if (httpMethod.equalsIgnoreCase("Delete")) {
            response = req.when().delete(APIResources.valueOf(resources).getResources()).then().extract().response();
        }
    }

    @Then("The API call got success with code {int}")
    public void the_api_call_got_success_with_code(int code) {
        assertEquals(response.getStatusCode(), code);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String bodyKey, String value) {
        assertEquals(getJsonValueFromKey(response, bodyKey), value);
    }

    @And("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String expectedName, String resources) throws IOException {
        placeId = getJsonValueFromKey(response, "place_id");
        req = given().spec(requestSpecification())
                .queryParam("place_id", placeId);
        user_calls_with_post(resources, "Get");
        String actualName = getJsonValueFromKey(response, "name");
        assertEquals(actualName, expectedName);
    }

    @Given("Give deletePlace payLoad")
    public void give_delete_place_pay_load() throws IOException {
        req = given().spec(requestSpecification()).body(data.getDeletePlacePayload(placeId));
    }
}
