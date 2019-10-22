# language: en
@tag
Feature: Find Board
  
  As a user I want to search for a board

  @find
  Scenario: Find a Board
    Given I have a board created and id 
    When execute endpoint <"https://api.trello.com/1/boards/"> with method GET
    Then api will Find a board for the user
    
     @find
  Scenario: Find a Board with invalid id board
    Given I have a invalid id board 
    When execute endpoint <"https://api.trello.com/1/boards/"> with method GET with invalid id board
    Then api will not find a board for the user and show the message <"invalid id">
    
      @find
  Scenario: Find a Board with invalid key
    Given I have a board created and id 
    When execute endpoint <"https://api.trello.com/1/boards/"> with method GET with invalid key
    Then api will not find a board for the user and show the message <"invalid key">
    
    
    
         @find
  Scenario: Find a Board with invalid token
    Given I have a board created and id 
    When execute endpoint <"https://api.trello.com/1/boards/"> with method GET with invalid token
    Then api will not find a board for the user and show the message <"invalid token">
    
    