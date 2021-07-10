@amazon
  Feature: Amazon random dropdown test
    As a user navigating on amazon website
  I want to randomly select category from amazon search dropdown

  Scenario: User Randomly selects category from amazon search dropdown
    Given John is on amazon website
    When John randomly selects a category from search dropdown
    Then the category is selected