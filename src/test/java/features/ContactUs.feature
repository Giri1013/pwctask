Feature: Verifying contact us page items
  @all
  Scenario: Verifying contact us page items
    Given I navigate to the PwC Digital Pulse website
    When I select "Contact us" from the hamburger menu
    Then I am taken to the "Contact us" page
    And I am presented with the below options for contacts
      | PwC Digital Services         | https://digital.pwc.com/en/contact-us.html |
      | Digital Pulse editorial team |                                            |
      | Careers at PwC               | https://www.pwc.com/gx/en/careers.html     |
      | General enquiries            | https://www.pwc.com/gx/en.html             |

