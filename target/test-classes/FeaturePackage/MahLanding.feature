Feature: MAH order form functionality with valid details

Background: 
Given Open url in browser
And Wait for page to load

Scenario: Verify order form with url and title
When I verify the title and url
Then Title with Url should match

Scenario: Verify the fields should accept valid details
When enter valid emailid
And valid subjects
And select date datepicker
And select time from dropdown
And enter assignment description
And attach a file





