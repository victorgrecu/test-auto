Feature: An user can use google to search information about different topics


  Scenario: Search after a single word keyword
    Given I am on Google Search Page
    When I search after "test"
    Then I get this list of results:
      | Speedtest by Ookla - The Global Broadband Speed Test        |
      | Test viteză internet - Digi                                 |
      | Fast.com: Internet Speed Test                               |
      | Speed Test - Telstra                                        |
      | Test Your Internet Speed – Internet Speed Check \| Spectrum |
      | Pingdom Tools: Website Speed Test                           |
      | Speakeasy Internet Speed Test - Check Your Broadband ...    |
      | Test My Site - Think with Google                            |
      | TestMy.net Broadband Internet Speed Test                    |
      | Broadband Speed Checker - UK's No.1 Broadband Speed Test    |


