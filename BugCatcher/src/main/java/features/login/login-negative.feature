Feature: Login

    Scenario Outline: Login Correct Username Wrong Password
        Given The employee is on the login page
        When  The employee types <username> into username input
        When The employee types <password> into password input
        When The employee clicks on the login button
        Then The employee should see an alert saying they have the wrong password
        Examples:
            | username | password |
            |"g8tor"   | "chOmp!"  |


    Scenario Outline: Login Wrong Username
        Given The employee is on the login page
        When The employee types <username> into username input
        When The employee types <password> into password input
        When The employee clicks on the login button 
        Then The employee should see an alert saying no user with that username found
        Examples:
            | username   | password  |
            |"sicEmDawgs"|"natchamps"|

        