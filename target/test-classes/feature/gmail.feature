Feature: Gmail 

Scenario: Sending an Email in Gmail with an attachment "1"
	Given I am logged in Gmail and on the main page			
	When I press send after I fill the recipient as "expprofile2@gmail.com", subject and insert the mcgill image	
	Then I can send mail with an attachment

Scenario: Sending an Email in Gmail with an attachment "2"
	Given I am logged in Gmail and on the main page			
	When I press send after I fill the recipient as "expprofile2@gmail.com", subject and insert the mcgill2 image		
	Then I can send mail with an attachment

Scenario: Sending an Email in Gmail with an attachment "3"
	Given I am logged in Gmail and on the main page			
	When I press send after I fill the recipient as "expprofile2@gmail.com", subject and insert the mcgill3 image		
	Then I can send mail with an attachment
	
Scenario: Sending an Email in Gmail with an attachment "4"
	Given I am logged in Gmail and on the main page			
	When I press send after I fill the recipient as "expprofile3@gmail.com", subject and insert the mcgill image	
	Then I can send mail with an attachment
	
Scenario: Sending an Email in Gmail with an attachment "5"
	Given I am logged in Gmail and on the main page			
	When I press send after I fill the recipient as "expprofile3@gmail.com", subject and insert the mcgill2 image	
	Then I can send mail with an attachment
	