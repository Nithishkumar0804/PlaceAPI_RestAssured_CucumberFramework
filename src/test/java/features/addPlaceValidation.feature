Feature: Validating place API's
@addPlace @Regression
  Scenario Outline: Verify if the place is successfully added by AddPlaceAPI
    Given Add place payload with "<name>" "<address>" "<language>"
    When user calls "addPlaceAPI" with request "Post"
    Then The API call got success with code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"
    Examples:
    |  name          | address                   | language    |
    | Frontline house| 29, side layout, cohen 09 | French-IN   |
#   | richard house  | 30, side layout, cohen 09 | French      |

  @deletePlace @Regression
  Scenario: verifying the deletePlaceAPI
    Given Give deletePlace payLoad
    When user calls "deletePlaceAPI" with request "Delete"
    Then The API call got success with code 200
    And "status" in response body is "OK"

