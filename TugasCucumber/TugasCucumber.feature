Feature: Create Scenario testing in opencart.com

  Background: user open https://www.opencart.com/index.php

  Scenario: user use function behavior
    Given user click menu demo
    When user click button back
    And user clik button forward
    And user click button refresh

  Scenario: user use function input "Signin with Unregisterd Email" dan web element
    Given user click button login
    When user input email "ramonesdai@gmail.com"
    And user input password "Halamadrid"
    Then user click button login


  Scenario:user use function element choose DropDown "https://demoqa.com"
    When user open menue dropdown
    Then user click menu "Old Select Menu"
    When user click menu checkbox
    And user click tree
    Then User click checkbox Download
