Feature: Validating end to end API

  @Login
  Scenario: Verify if the user login sucessfully
    Given Login payload with "userEmail" and "userPassword"
    When user calls LoginAPI with POST http request
    Then the API call got success with status code 200
    And "message" in response body is "Login Successfully"
    And verify userId and token created