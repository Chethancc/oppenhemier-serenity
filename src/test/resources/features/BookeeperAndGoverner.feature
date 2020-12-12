Feature: To login as Bookeeper and check if able to fetch the records of


# Data to be compared with calculation of inserted data and received tax relief data
  Scenario: To verify if calculated tax relief is > O and <=50 then final tax relief should be 50.00
    Given I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then proper users must be present for tax releif <50

# Data extracted from the url is compared with data in the DB
  Scenario: To verify if calculated tax relief is >50 then final tax relief should be same as calculated tax releif
    Given I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then proper user data for tax relief >50 must be present

  Scenario: To truncate and round off tax relief with >2 decimal places for >50 and verify tax relief should be same as final tax releif
    Given I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then response should contain tax relief amount with only 2 decimal places

  Scenario: To truncate and round off tax relief with >2 decimal places for <=50 and verify final tax relief should be 50
    Given I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then response should contain tax relief amount with only 2 decimal places

  Scenario: To verify Variable amount of 1 is used for tax relief calculation for user with age <=18
    Given I login as a clerk
    And add insert multiple working heros with profile
      |Profile1|
      |Profile2|
      |Profile3|
      |Profile4|
      |Profile5|
    Then I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then variable amount should be 1 for user with age <=18


  Scenario: To verify Variable amount of 0.8 is used for tax relief calculation with age between >18 and <=35
    Given I login as a clerk
    And add insert multiple working heros with profile
      |Profile1|
      |Profile2|
      |Profile3|
      |Profile4|
      |Profile5|
    Then I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then variable amount should be "0.8" for user with age greater than "18" and less than equal to "35"

  Scenario: To verify Variable variable amount of 0.5 is used for tax relief calculation with age >35 and <=50
    Given I login as a clerk
    And add insert multiple working heros with profile
      |Profile1|
      |Profile2|
      |Profile3|
      |Profile4|
      |Profile5|
    Then I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then variable amount should be "0.5" for user with age greater than "35" and less than equal to "50"
#
  Scenario: To verify Variable variable amount of 0.5 is used for tax relief calculation with age >50 and <=75
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
    Then I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then variable amount should be "0.367" for user with age greater than "50" and less than equal to "75"

  Scenario: To verify Variable variable amount of 0.5 is used for tax relief calculation with age >50 and <=75
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
    Then I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then variable amount should be "0.05" for user with age greater than "75" and less than equal to "76"

  Scenario: To verify gender bonus of 500 is added for female customer
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
    Then I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then gender bonus of "500" should be added for "Female" candidates

  Scenario: To verify gender bonus of 500 is added for female customer
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
    Then I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then gender bonus of "0" should be added for "Male" candidates


#    This is a UI test to get the details of the working hero and dispense the amount
  Scenario: To login as governer and verify the dispense to dispense cash
    Given I login as a Governer
    And able to see the tax relief details
    Then should be able to dipense the amount

