
Feature: Batch Module

  Background:
    Given Admin generates valid token

  Scenario Outline: Get all batches with "<Scenario>"
    When Admin sends "<Method>" request to get all batches with "<EndpointType>" endpoint and "<TokenType>" token
    Then Admin receives <Statuscode> status code

    Examples:
      | Scenario         | Method | EndpointType | TokenType | Statuscode |
      | invalid endpoint | GET    | invalid      | valid     | 404        |
      | invalid method   | PUT    | valid        | valid     | 405        |
      | invalid token    | GET    | valid        | invalid   | 401        |
      | valid endpoint   | GET    | valid        | valid     | 200        |

  @runthis
  Scenario Outline: Add New batch with "<Scenario>"
    When Admin sends POST request to create new batch using "<Scenario>"
    Then Admin receives <Statuscode> status code

    Examples:
      | Scenario                                                                               | Statuscode |
      |Admin creates batch with a program name that does not match the associated program id   |  201       |
      |Admin creates batch with only optional fields                                           |  400       |
      |Admin creates batch without underscore format in batch name                             |  400       |
      |Admin creates batch with hyphen format in batch name                                    |  400       |
      |Admin creates batch with characters in the suffix of batch name                         |  400       |
      |Admin creates batch with special characters in the suffix of batch name                 |  400       |
      |Admin creates batch with batch name length more than 28 characters in total             |  400       |
      |Admin creates batch with batch name length less than 6 characters in total              |  400       |
      |Admin creates batch with only mandatory fields                                          |  201       |
      | Admin creates batch with duplicate batch name                                          |  400       |
      | Admin creates batch with batch description less than 4 characters                      |  400       |
      |Admin creates batch with batch description more than 25 characters                      |  400       |
      |Admin creates batch with random characters in status field                              |  400       |
      |Admin creates batch with random numbers in status field                                 |  400       |
      |Admin creates batch with special characters in status field                             |  400       |
      |Admin creates batch with non numeric value in number of classes                         |  400       |
      |Admin creates batch with number of classes length less than 1                           |  400       |
      |Admin creates batch with number of classes length more than 99                          |  400       |
      |Admin creates batch with inactive program ID                                            |  400       |
      |Admin creates batch with program that is not exist in the system                        |  404       |
      |Admin creates batch with invalid endpoint                                               |  404       |
      |Admin creates batch with invalid method                                                 |  405       |
      |Admin creates a batch with invalid token                                                |  401       |
      |Admin creates batch with both mandatory and optional fields                             |  201       |


  Scenario Outline: Get batch "<RequestType>" with "<Scenario>"
    When Admin sends GET request to get batch "<RequestType>" using "<Scenario>"
    Then Admin receives <Statuscode> status code

    Examples:
      | RequestType           | Scenario             | Statuscode |
      | by BatchId            | valid batchid        | 200        |
      | by BatchId            | invalid batchid      | 404        |
      | by BatchId            | inactive batchid     | 200        |
      | by BatchId            | invalid endpoint     | 404        |
      | by BatchId            | invalid method       | 405        |
      | by BatchId            | invalid token        | 401        |
      | by BatchName          | valid BatchName      | 200        |
      | by BatchName          | invalid BatchName    | 404        |
      | by BatchName          | invalid endpoint     | 404        |
      | by BatchName          | invalid method       | 405        |
      | by BatchName          | invalid token        | 401        |
      | by ProgramId          | valid ProgramId      | 200        |
      | by ProgramId          | invalid ProgramId    | 404        |
      | by ProgramId          | invalid endpoint     | 404        |
      | by ProgramId          | invalid method       | 405        |
      | by ProgramId          | invalid token        | 401        |

  @runthis
  Scenario Outline: Update Batch by BatchId with "<Scenario>"
    When Admin sends PUT request to update Batch by BatchId using "<Scenario>"
    Then Admin receives <Statuscode> status code

    Examples:
    | Scenario                                                                                            | Statuscode |
    | Admin updates a batch with invalid batch ID                                                         | 404        |
    | Admin updates a batch by batch id with missing mandatory fields in request body                     | 400        |
    | Admin updates a batch with valid batch ID                                                           | 200        |
    | Admin updates a batch by batch id with duplicate batch name                                         | 400        |
    | Admin updates a batch by batch id with invalid batch name format                                    | 400        |
    | Admin updates a batch by batch id with batch name more than allowable length                        | 400        |
    | Admin updates a batch by batch id with batch name less than allowable length in total               | 400        |
    | Admin updates a batch by batch id with invalid batch description                                    | 400        |
    | Admin updates a batch by batch id with invalid batch status                                         | 400        |
    | Admin updates a batch by batch id with invalid batch number of classes                              | 400        |
    | Admin updates a batch by batch id with invalid program id                                           | 404        |
    | Admin updates a batch by batch id with special characters in program name                           | 400        |
    | Admin updates a batch by batch id with numbers in program name                                      | 400        |
    | Admin updates a batch by batch id with a program name that does not match the associated program id | 200        |
    | Admin updates a batch by batch id with inactive program                                             | 400        |
    | Admin updates a batch by batch id with invalid endpoint                                             | 404        |
    | Admin updates a batch by batch id with invalid method                                               | 405        |
    | Admin updates a batch by batch id with invalid token                                                | 401        |
   # | Admin updates a batch with valid batch ID                                                           | 200        |

