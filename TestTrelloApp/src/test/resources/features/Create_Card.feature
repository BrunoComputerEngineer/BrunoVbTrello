# language: en
@tag
Feature: Create Card
  As a user
  I want to be able to create a card

  @Card
  Scenario: Create a Card
    Given I have a board created for the card
    When execute endpoint <"https://api.trello.com/1/cards/"> to card
    Then api will create a card for the user
    And the status code will be <"200">

  @Card
  Scenario: create a card for a nonexistent list
    Given that I pass a non-existent id list
    When execute endpoint <"https://api.trello.com/1/cards/"> to card with id List invalid
    Then the API will not create a card for the user.
    And the status code will be <"400">
    And the message response will be <"invalid value for idList">

  @Card
  Scenario: create a card for a invalid key
    Given that I pass a invalid key for the api
    When execute endpoint <"https://api.trello.com/1/cards/"> to card with invalid key
    Then the API will not create a card for the user.
    And the status code will be <"401">
    And the message response will be <"invalid key">

  @Card
  Scenario: create a card for a invalid Token
    Given that I pass a invalid token for the api
    When execute endpoint <"https://api.trello.com/1/cards/"> to card with invalid token
    Then the API will not create a card for the user.
    And the status code will be <"401">
    And the message response will be <"invalid token">

  @Card
  Scenario: do not pass an id list in the request body
    Given I didn't pass an id list in the body of the request
    When execute endpoint <"https://api.trello.com/1/cards/"> to card without id List
    Then the API will not create a card for the user.
    And the status code will be <"404">
    And the message response will be <"invalid value for idList">
