Feature: SignUp functionality with valid details

Background: 
Given Open signup url in browser
And Wait for signup page to load

@sanity
Scenario: 
When i enter valid details
|Name|Emailid|PhoneNo|
|Gaurav|abc@gmail.com|12345|
|Gaurav1|abcd@gmail.com|123456|
|Gaurav2|abcde@gmail.com|1234567s|


