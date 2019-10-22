# language: en
@tag
Feature: Create Board
  As a user
  I want to be able to create a board

  @Board
  Scenario: Create a Board
    Given that I own the key and the token
    When execute endpoint <"https://api.trello.com/1/boards/">
    Then api will create a board for the user

  @Board
  Scenario: Insert a Board With an Invalid Token
    Given that I own the key and the token
    When execute endpoint <"https://api.trello.com/1/boards/"> with invalid token
    Then api will not create a board for the user and show the message <"invalid token">

  @Board
  Scenario: Insert a Board With An Invalid Key
    Given that I own the key and the token
    When execute endpoint <"https://api.trello.com/1/boards/"> with invalid key
    Then api will not create a board for the user and show the message <"invalid key">
