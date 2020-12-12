Feature: To login as Clerk and verify user able to add working hero record

#  to create a single user , here we are checking for response of 202 where data is inserted and a Message accepted is sent
  Scenario: To add single record of working hero and verify the application
    Given I login as a clerk
    And add the details of the working hero
    Then details must be successfully updated



  Scenario: To add multiple record of working heros and verify
    Given I login as a clerk
    And add insert multiple working heros with profile
      |Profile1|
      |Profile2|
      |Profile3|
      |Profile4|
      |Profile5|
      |Profile6|
      |Profile7|
      |Profile8|
      |Profile9|
      |Profile10|
    Then details must be successufully updated in DB


  Scenario: To upload data file of working heros through API and verify
    Given I login as a clerk
    And insert multiple records of users via API
    Then details must be successufully updated in DB

