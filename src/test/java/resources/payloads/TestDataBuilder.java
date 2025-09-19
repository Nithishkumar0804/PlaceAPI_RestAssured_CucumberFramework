package resources.payloads;

import pojoClasses.Location;
import pojoClasses.addPlace;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {
    public addPlace addPlacePayload(String name, String address, String language) {
        addPlace addPlace = new addPlace();
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);
        addPlace.setAccuracy(50);
        addPlace.setName(name);
        addPlace.setPhoneNumber("(+91) 983 893 3937");
        addPlace.setAddress(address);
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage(language);
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        addPlace.setTypes(types);
        return addPlace;
    }

    public String getDeletePlacePayload(String placeId) {
        return "{\n" +
                "    \"place_id\":\"" + placeId + "\"\n" +
                "}\n";
    }
}
