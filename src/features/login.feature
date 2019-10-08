Feature: WebOrders Login
#@table
  Scenario: Login Test

    Given user navigates Web Orders homepage
    When  user enters valid username and password
    Then  user login should be successful