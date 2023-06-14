Feature: Login functionality for Leaftaps application

#Background:
#Given Open the browser
#And Load the URL as 'http://leaftaps.com/opentaps'

@Smoke
Scenario: Login - Postive test case
Given Enter the username as 'DemoCSR'
And Enter the password as 'crmsfa'
When Click on Login button
Then Verify logon successful

@Regression
Scenario: Login - Negative test case
Given Enter the username as 'Dsalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
But Logon Denied



