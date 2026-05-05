
Feature: Login Module

Background:
  Given Admin sets authorization as "noAuth"

Scenario Outline: Validate login API with different combinations
 
  Given Admin creates testData for "<scenarioType>" and "<Endpoint>"
  When Admin sends "<Method>" request to "<Endpoint>" endpoint
  Then Admin receives status code <StatusCode>

Examples:
  | scenarioType       | Method | Endpoint      | StatusCode |
  | Empty Email        | POST   | loginEndpt    | 400        |
  | Special Char Email | POST   | loginEndpt    | 400        |
  | Email with Spaces  | POST   | loginEndpt    | 400        |
  | Null Email         | POST   | loginEndpt    | 400        |
  | Unregistered Email | POST   | loginEndpt    | 400        |
  | Empty Password     | POST   | loginEndpt    | 400        |
  | Special Char Password| POST | loginEndpt    | 401        |
  | Password with Spaces| POST   | loginEndpt   | 400        |
  | Null Password       | POST   | loginEndpt   | 400        |
  | Inactive User       | POST   | loginEndpt   | 400        |
  | Invalid Method     | GET    | loginEndpt    | 405        |
  | Invalid Endpoint   | POST   | invalidEndpt  | 401        |
  

     Scenario Outline: Admin generate token with valid login credentials
    Given Admin creates valid login test data
     When Admin sends "<Method>" request to "<Endpoint>" endpoint
    Then Admin receives Token with statusCode <StatusCode> in response
    Examples:
      |Method | Endpoint      | StatusCode |
      | POST   | loginEndpt    | 200       |
    
