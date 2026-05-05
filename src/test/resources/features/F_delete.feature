
Feature: Data Cleanup Module

  Background:
    Given Admin generates valid token

  Scenario Outline: Delete Batch By BatchId with "<Scenario>"
    When Admin sends DELETE request to delete batch by batch id using "<Scenario>"
    Then Admin receives <Statuscode> status code

    Examples:
      | Scenario               |  Statuscode |
      | invalid BatchId        | 404         |
      | invalid endpoint       | 404         |
      | invalid method         | 405         |
      | invalid token          | 401         |
      | valid BatchId          | 200         |

  Scenario Outline: Delete Program By ProgramId with "<Scenario>"
    When Admin sends DELETE request to delete program by program id using "<Scenario>"
    Then Admin receives <Statuscode> status code

    Examples:
      | Scenario               |  Statuscode |
      | invalid ProgramId      | 404         |
      | invalid endpoint       | 404         |
      | invalid method         | 405         |
      | invalid token          | 401         |
      | valid ProgramId        | 200         |


  Scenario Outline: Delete Program By ProgramName with "<Scenario>"
    When Admin sends DELETE request to delete program by ProgramName using "<Scenario>"
    Then Admin receives <Statuscode> status code

    Examples:
      | Scenario               |  Statuscode |
      | invalid ProgramName    | 404         |
      | invalid endpoint       | 404         |
      | invalid method         | 405         |
      | invalid token          | 401         |
      | valid ProgramName      | 200         |


  Scenario Outline: Validate Logout
    Given Admin sets authorization as "<authType>"
    Given Admin creates testData for "<scenarioType>" and "<Endpoint>"
    When Admin sends "<Method>" request to "<Endpoint>" endpoint
    Then Admin receives statusCode <StatusCode>

  Examples:
    | scenarioType        | authType     | Method | Endpoint     | StatusCode |
    | Invalid Endpoint    | BearerToken  | GET    | invalidEndpt | 404        |
    | Invalid Method      | BearerToken  | POST   | logoutEndpt  | 405        |
    | Valid Logout        | BearerToken  | GET    | logoutEndpt  |  200       |
    | No Auth             | NoAuth       | GET    | logoutEndpt  | 401        |
    | Invalid Token       | InvalidToken | GET    | logoutEndpt  | 401        |
    | Expired Token       | ExpiredToken | GET    |logoutEndpt   | 401        |

