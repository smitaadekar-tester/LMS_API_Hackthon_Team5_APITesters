Feature: Checking Forgot password functionalities

Background:
 Given Admin sets authorization as "noAuth"

 Scenario Outline: Validate Forgot Password/Confirm Email
    Given Admin creates testData for "<scenarioType>" and "<Endpoint>"
    When Admin sends "<Method>" request to "<Endpoint>" endpoint
    Then Admin receives status code <statusCode>

  Examples:
    | scenarioType          | Method | Endpoint | statusCode |
    | Invalid Method       | GET    | forgotPswdEndpt| 405        |
    | Invalid Endpoint     | POST   | invalidEndpt   | 404      |
    | Empty Email          | POST   | forgotPswdEndpt| 400        |
    | Invalid Email        | POST   | forgotPswdEndpt| 400        |
    | Null Email           | POST   | forgotPswdEndpt| 400        |
    | Unregistered Email   | POST   | forgotPswdEndpt| 400        |
  #
  #
