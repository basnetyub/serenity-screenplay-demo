@facebook
Feature: Facebook Login of Registered User
  As a registered user
  I want to login and validate login

  Scenario: User logins to facebook with incorrect credentials
    Given John is on Facebook login page
    When John enters following credentials
      | UserName  | Password       |
      | basnetyub | testingtesting |
    Then John gets "The password you’ve entered is incorrect." error