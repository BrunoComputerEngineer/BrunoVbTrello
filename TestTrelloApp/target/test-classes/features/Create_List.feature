# language: en

@tag
Feature: Create List
  As a user
  I want to be able to create a List
  
  
    @List
  Scenario: Create a List
    Given I have a board created for the list
    When execute endpoint <"https://api.trello.com/1/boards/"> to list
    Then api will create a List for the user