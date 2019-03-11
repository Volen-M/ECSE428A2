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
	
Scenario: Seeing an Email in Gmail 
	Given I have mail and I am logged in Gmail and on the main page
	When I press on an email I have received
	Then I can see the email I have received	

Scenario: Deleting an Email 
	Given I have mail and I am logged in Gmail and on the main page		
	When I press on an email I have received
	And I press the garbage bin icon
	Then I have deleted the email I was on




 