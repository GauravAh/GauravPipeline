Feature: Login functinality with valid and invalid credentials

Background: 
Given Open login url in browser
And Wait for login page to load


Scenario: Login with valid details
When enter valid emailid as "gauravabsas12345@gmail.com"
And enter valid password as "112233"

Scenario Outline: Login with multiple details
When enter emailid as "<Username>"
And enter password as "<Password>"
Examples:
|Username|Password|
|nemail@yopmail.com|123|
|nemail1@yopmail.com|123456|
