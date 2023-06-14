Feature: EditLeads for Leaftaps application

#Background:
#Given Open the browser
#And Load the URL as 'http://leaftaps.com/opentaps'

@Sanity
Scenario Outline: EditLeads for valid data
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
And Click on first displayed Lead
And Click on Edit button
Given Update CompanyName as <companyName>
When Click on Submit Button in EditLead screen
Then Verify Lead updated as <companyName>

Examples:
|companyName|phoneNumber|
|Infosys|98|
|Citizens|97|