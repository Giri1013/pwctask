Feature: Verifying number of search results
  @all
  Scenario: Verify that atleast expected number of results is presented when search is performed
    Given I navigate to the PwC Digital Pulse website
    When I click on the "Magnifying glass" icon to perform a search
    And I enter the text "Single page applications"
    And I submit the search
    When I am viewing the "Search Results" page
#    Then I am taken to the search results page
    And I am presented with at least "1" search result