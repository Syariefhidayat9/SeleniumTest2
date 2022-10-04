Feature: Login feature

   Scenario Outline: User Login, Input Email And Password
     Given user on page "https://www.opencart.com/index.php?route=account/login"
       And user fill collom Email "ramonesdai@gmail.com"
       And user fill collom password
       And user click login
     Then user see alert login

     Examples:
       | Input Password  | output |
       | Halamadrid9     | True   |
       |                 | False  |