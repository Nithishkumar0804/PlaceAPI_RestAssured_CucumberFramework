package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@deletePlace")
    public void beforeScenario() throws IOException {
        PlaceApiStepDefinition obj = new PlaceApiStepDefinition();
        if (PlaceApiStepDefinition.placeId == null) {
            obj.add_place_payload_name_address_language("HooksName", "HooksAddress", "IND");
            obj.user_calls_with_post("addPlaceAPI", "Post");
            obj.verifyPlace_IdCreatedMapsToUsing("HooksName", "getPlaceAPI");
        }
    }
}
