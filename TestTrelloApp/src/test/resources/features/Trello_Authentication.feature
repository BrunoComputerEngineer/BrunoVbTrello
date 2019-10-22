# language: en
@tag
Feature: Trello Authentication
  As a user
  I want to perform authentication in Trello

  @tag1
  Scenario: GetAccessToken
    Given I created a profile in trello
    When execute endpoint "Endpoint"
    Then api will return the access token
