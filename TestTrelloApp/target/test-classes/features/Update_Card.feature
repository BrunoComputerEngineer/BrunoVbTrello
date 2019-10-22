# language: en
@tag
Feature: Update Card
  As a user
  I want to be able to update a card

  @UpdateCard
  Scenario: update a Card
    Given I have a board created for the update a card
    When execute endpoint <"https://api.trello.com/1/cards/"> to card update
    Then api will update a card for the user
    And the status code will be <"200">
    And the name of card is change to <"UpdateCardName">
    And the desc of card is change to <"UpdateCardDesc">

  @UpdateCard
  Scenario: update a Card with invalid id card
    Given that I have an invalid id card
    When execute endpoint <"https://api.trello.com/1/cards/"> to card update with invalid id card
    Then api will not update a card for the user
    And the status code will be <"400">
    And the message of response is <"invalid id">

  @UpdateCard
  Scenario: update a Card with invalid key
    Given that I have an invalid key
    When execute endpoint <"https://api.trello.com/1/cards/"> to card update with invalid key
    Then api will not update a card for the user
    And the status code will be <"400">
    And the message of response is <"invalid key">

  @UpdateCard
  Scenario: update a Card with invalid token
    Given that I have an invalid token
    When execute endpoint <"https://api.trello.com/1/cards/"> to card update with invalid token
    Then api will not update a card for the user
    And the status code will be <"401">
    And the message of response is <"invalid token">

  @UpdateCard
  Scenario: update a Card without changing anything
    Given I have a board created for the update a card without changing anything
    When execute endpoint <"https://api.trello.com/1/cards/"> to card update  without changing anything
    Then api will not update a card for the user
    And the status code will be <"200">
