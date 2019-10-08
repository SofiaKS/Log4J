Feature: Placing an order
  @table
  Scenario Outline: filling out order

    Given user navigates to Orders page
    When user selects product "<product>"
    And user enters the number of quantity "<quantity>"
    And user clicks on calculate
    And user enters customer name "<name>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip code "<zip code>"
    And user chooses card to pay "<card>"
    And user enters card number "<Card Nr>"
    And user enters expiry date "<Expiry Date>"
    And user clicks Process button
    Then user should see a message "New order has been successfully added."

    Examples:

      |product		|quantity	|name		|street		|city	|state	|zip code	|card			 |Card Nr	  |Expiry Date	|
      |FamilyAlbum	|4			|John Wick	|S Lee str.	|Chicago|IL		|60065		|Visa			 |63746732647 |09/23		|
      |ScreenSaver	|2			|Adam Smith	|N Wolf str.|Huston |Texas	|54895		|American Express|7634756437  |05/14		|