#Feature: Program Module
#
  #Background:
    #Given Admin sets Authorization to Bearer Token
#
#
  #Scenario Outline: Get all programs with "<Scenario>"
    #When Admin sends "<Method>" request to get all programs with "<EndpointType>" endpoint and "<TokenType>" token
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario         | Method | EndpointType | TokenType | Statuscode |
      #| invalid endpoint | GET    | invalid      | valid     | 404        |
      #| invalid method   | POST   | valid        | valid     | 405        |
      #| invalid token    | GET    | valid        | invalid   | 401        |
      #| valid endpoint   | GET    | valid        | valid     | 200        |
#
#
  #Scenario Outline: GET All Programs with Users "<Scenario>"
    #When Admin sends "<Method>" request to get all programs with Users "<EndpointType>" endpoint and "<TokenType>" token
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario         | Method | EndpointType | TokenType | Statuscode |
      #| invalid endpoint | GET    | invalid      | valid     | 404        |
      #| invalid method   | POST   | valid        | valid     | 405        |
      #| invalid token    | GET    | valid        | invalid   | 401        |
      #| valid endpoint   | GET    | valid        | valid     | 200        |
#
#
  #Scenario Outline: Add New program with "<Scenario>"
    #When Admin sends POST request to create new program using "<Scenario>"
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario                                                                       | Statuscode |
      #|Admin creates a program with already existing program name                      | 400        |
      #|Admin creates a program with trailing space in program name                     | 400        |
      #|Admin creates a program with only numbers in program name                       | 400        |
      #|Admin creates a program with invalid status keyword                             | 400        |
      #|Admin creates a program without Program name                                    | 400        |
      #|Admin creates a program with Program name length less than desired length       | 400        |
      #|Admin creates a program with empty payload                                      | 400        |
      #|Admin creates a program with alpha & special char in program description        | 400        |
      #|Admin creates a program with program description length more than desired length| 400        |
      #| invalid endpoint                                                               | 404        |
      #| invalid method                                                                 | 405        |
      #| invalid token                                                                  | 401        |
      #|Admin creates a program with valid request body and authorization               | 201        |
      #|Admin creates a program with only mandatory field                               | 201        |
#
#
  #Scenario Outline: GET Program by ProgramId with "<Scenario>"
    #When Admin sends GET request to retrieve program by program id using "<Scenario>"
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario                                  | Statuscode |
      #| valid program ID                          | 200        |
      #| invalid program ID                        | 404        |
     # | invalid baseURI                           | 404        |
      #| invalid endpoint                          | 404        |
      #| without authorization                     | 401        |
#
  #Scenario Outline: Update Program by ProgramId with "<Scenario>"
    #When Admin sends PUT request to update program by program id using "<Scenario>"
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario                                                                       | Statuscode |
      #|  Admin updates a program with invalid program id                               | 404        |
      #| Admin updates a program with already existing program name in request body     | 400        |
      #| Admin updates a program with no request body                                   | 400        |
      #| Admin updates a program with invalid baseURI                                   | 404        |
      #| invalid method                                                                 | 405        |
      #| invalid endpoint                                                               | 404        |
      #| invalid token                                                                  | 401        |
      #|Admin updates a program with valid program id                                   | 200        |
#
#
  #Scenario Outline: Update Program by ProgramName with "<Scenario>"
    #When Admin sends PUT request to update program by ProgramName using "<Scenario>"
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario                                                                       | Statuscode |
      #| Admin updates a program with invalid program Name                              |  404       |
      #| Admin updates a program missing mandatory fields in request body               | 400        |
      #| Admin updates a program with invalid status in request body                    | 400        |
      #| Admin updates a program with only spl char program Description in request body | 400        |
      #| Admin updates a program with invalid token                                     | 401        |
      #| Admin updates a program with valid status                                      | 200        |
      #| Admin updates a program with valid program Name                                | 200        |
#
#
  #Scenario Outline: Delete Program By ProgramId with "<Scenario>"
    #When Admin sends DELETE request to delete program by program id using "<Scenario>"
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario               |  Statuscode |
      #| invalid ProgramId      | 404         |
      #| invalid endpoint       | 404         |
      #| invalid method         | 405         |
      #| invalid token          | 401         |
      #| valid ProgramId        | 200         |
#
#
  #Scenario Outline: Delete Program By ProgramName with "<Scenario>"
    #When Admin sends DELETE request to delete program by ProgramName using "<Scenario>"
    #Then Admin receives <Statuscode> status code
#
    #Examples:
      #| Scenario               |  Statuscode |
      #| invalid ProgramName    | 404         |
      #| invalid endpoint       | 404         |
      #| invalid method         | 405         |
      #| invalid token          | 401         |
      #| valid ProgramName      | 200         |
#
#
#
#
#
#
#
#
#
#
