
Feature: checking Reset Password functionalities

    Scenario Outline: Validate Reset Password
    Given Admin sets authorization as "<authType>"
    Given Admin creates testData for "<scenarioType>" and "<Endpoint>"
    When Admin sends "<Method>" request to "<Endpoint>" endpoint
    Then Admin receives status code <StatusCode>

  Examples:
    | scenarioType             | authType        | Method | Endpoint      | StatusCode |
    | Valid Reset              | BearerToken     | POST   | resetPswdEndpt| 200        |
    | Invalid Email            | BearerToken     | POST   |resetPswdEndpt | 400        |
    | Invalid Password         | BearerToken     | POST   |resetPswdEndpt | 400        |
    | Invalid Endpoint         | BearerToken     | POST   | invalidEndpt  | 404        |
    | Invalid Method           | BearerToken     | GET    | resetPswdEndpt | 405       |
    | Empty Token              | EmptyToken      | POST   |resetPswdEndpt  | 401       |


