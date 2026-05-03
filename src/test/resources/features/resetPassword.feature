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
    
    #@logout
  #Scenario Outline: Validate Logout 
   #Given Admin sets authorization as "<authType>"
    #Given Admin creates testData for "<scenarioType>" and "<Endpoint>"
    #When Admin sends "<Method>" request to "<Endpoint>" endpoint
    #Then Admin receives statusCode <StatusCode> with response message "<message>"
#
  #Examples:
    #| scenarioType        | authType     | Method | Endpoint     | StatusCode | message             |
    #| Invalid Endpoint    | BearerToken  | GET    | invalidEndpt | 404        | Not Found           |
    #| Invalid Method      | BearerToken  | POST   | logoutEndpt  | 405        | Method Not Allowed  |
     #| Valid Logout        | BearerToken  | GET    | logoutEndpt  |  200       | Logout successful   |
    #| No Auth             | NoAuth       | GET    | logoutEndpt  | 401        | Unauthorized        |
    #| Invalid Token       | InvalidToken | GET    | logoutEndpt  | 401        | Unauthorized        |
    #| Expired Token       | ExpiredToken | GET    |logoutEndpt   | 401        | Unauthorized        |
             #
    #
