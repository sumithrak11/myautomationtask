Feature: Login
@login
Scenario: Login successully
Given User should be launch in Todo webpage
When Login to the web page
And Naviage to home page
Then check login is success

@CreateTodo
Scenario: Create 10 todo List
Given Land into Todo Page
When Add Ten todo list
Then log off from App

@loginAgain
Scenario: Login successully
Given User should be launch in Todo webpage
When Login to the web page
And Naviage to home page
Then check login is success


@DeleteTodos
Scenario: Delete created todo list
Given Land into Todo Page
When Delete my to do items
Then check my to do has five

   
