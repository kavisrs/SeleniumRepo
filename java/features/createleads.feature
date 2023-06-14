Feature: CreateLeads for Leaftaps application

#Background:
#Given Open the browser
#And Load the URL as 'http://leaftaps.com/opentaps'

@Smoke @Functional
Scenario Outline: CreateLeads for valid data
Given Enter the username as 'DemoCSR'
And Enter the password as 'crmsfa'
When Click on Login button
Then Verify logon successful
When Click on CRM-SFA
And Click on Leads
And Click on CreateLead button
Given Enter Firstname as <firstName>
And Enter LastName as <lastName>
And Enter CompanyName as <cName>
And Enter PhoneNumber as <phoneNumber>
When Click on Submit Button
Then Verify Lead creted

Examples:
|firstName|lastName|cName|phoneNumber|
|Kavitha|R|Infosys|98|
|Aiswarya|G|Citizens|97|