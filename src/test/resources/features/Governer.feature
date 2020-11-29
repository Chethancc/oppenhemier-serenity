Feature: To login as Governer and verify all user details are present and able to dispense the cash

#This is UI test to verify governer can dispense the money
  Scenario: To login as governer and verify to dispense cash
    Given I login as a Governer
    And able to see the tax relief details
    Then should be able to dipense the amount
