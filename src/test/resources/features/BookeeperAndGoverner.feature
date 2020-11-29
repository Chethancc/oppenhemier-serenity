Feature: To login as Bookeeper and check if able to fetch the records of

# Data extracted from the url is compared with data in the DB

  Scenario: To verify all the users who has tax relief <50
    Given I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then proper users must be present for tax releif <50

# Data extracted from the url is compared with data in the DB

  Scenario: To verify all the users who has tax relief >50
    Given I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then proper user data for tax relief >50 must be present
#
#
  Scenario: To verify all the tax relief response contains values with decimal point of 2
    Given I login as a Bookeeper
    And Rake the database via API
    And Insert data to DB via API
    And get the users with tax releif
    Then response should contain tax relief amount with only 2 decimal places

#    This is a UI test to get the details of the working hero and dispense the amount
  Scenario: To login as governer and verify to dispense cash
    Given I login as a Governer
    And able to see the tax relief details
    Then should be able to dipense the amount
