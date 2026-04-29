
Feature: Login Module
 
Scenario: valid login
    #Given Admin creates login request with valid credentials
    When Admin send Post request with valid endpoints
    #Then Admin recieves Token in response 
   