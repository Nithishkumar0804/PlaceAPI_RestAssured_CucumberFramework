package resources;

public enum APIResources {
    addPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json"),
    updatePlaceAPI("/maps/api/place/update/json");

    private final String resources;

    APIResources(String resources) {
        this.resources = resources;
    }

    public String getResources() {
        return resources;
    }
}
