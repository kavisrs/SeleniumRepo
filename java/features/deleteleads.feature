Feature: DeleteLeads for Leaftaps application

#Background:
#Given Open the browser
#@And Load the URL as 'http://leaftaps.com/opentaps'

@Regression
Scenario Outline: DeleteLeads for valid data
Given Enter the username as 'DemoCSR'
And Enter the password as 'crmsfa'
When Click on Login button
Then Verify logon successful
When Click on CRM-SFA
And Click on Leads
And Click on FindLeads
And Click on Phone
Given Enter PhoneNumber for finding lead as <phoneNumber>
When Click on FindLeads button
And Get leadID for first displayed Lead
And Click on Delete button
And Click on FindLeads 
Given Enter leadID
When Click on FindLeads button
Then Verify Lead Deleted

Examples:
|phoneNumber|
|0|