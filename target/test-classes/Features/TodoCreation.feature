Feature: Create Todo lists
Scenario: Create 10 todo lists after successful login
Given User should be launch in Todo webpage

When Create todo lists and logoff
And Delete last five todo lists created
Then check deletion successful or not  
  

   
