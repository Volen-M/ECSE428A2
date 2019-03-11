package stepdefinitions;

import cucumber.api.java.After;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.gmailautomation.WebsiteDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps {
	private FirefoxDriver driver = WebsiteDriver.setUpFireFoxDriver();
	private WebDriverWait wait = WebsiteDriver.setUpWaitDriver(driver);
	
	
    @Given("^I am logged in Gmail and on the main page$")
    public void logon() {
    	WebsiteDriver.logInToGmail(driver, wait, "expprofile1@gmail.com", "accountpassword1");
    }

    @Given("^I have mail and I am logged in Gmail and on the main page$")
    public void logonRecipient() {
    	WebsiteDriver.logInToGmail(driver, wait, "expprofile2@gmail.com", "accountpassword2");
    }

	 @Given("^I am logged in Gmail and I am on an email$")
    public void logonEmail() {
    	WebsiteDriver.logInToGmail(driver, wait, "expprofile2@gmail.com", "accountpassword2");
    }
	
    @When("^I press send after I fill the recipient as \"(.*)\", subject and insert the mcgill image$")
    public void mcgill(String query) {
    	try {
    		WebsiteDriver.setupMail(driver, wait, "\\img\\mcgill.jpg", query, "Test_Email");
    	}
    	catch (Exception e) {
    		Assert.assertFalse(true);
    	}
    }

    @When("^I press send after I fill the recipient as \"(.*)\", subject and insert the mcgill2 image$")
    public void mcgill2(String query) {
    	try {
    		WebsiteDriver.setupMail(driver, wait, "\\img\\mcgill2.png", query, "Test_Email");
    	}
    	catch (Exception e) {
    		Assert.assertFalse(true);
    	}
    }
    
    @When("^I press send after I fill the recipient as \"(.*)\", subject and insert the mcgill3 image$")
    public void mcgill3(String query) {
    	try {
    		WebsiteDriver.setupMail(driver, wait, "\\img\\mcgill3.png", query, "Test_Email");
    	}
    	catch (Exception e) {
    		Assert.assertFalse(true);
    	}
    }
    
    @When("^I press on an email I have received$")
    public void emailOpen() {
		WebsiteDriver.openFirstMail( driver,  wait);
    	
    }
    @And("^I press the garbage bin icon$")
    public void delete() {
    	WebsiteDriver.deleteEmail(driver, wait);
    }

    @Then("^I have deleted the email I was on$")
    public void deleteCheck() {
    	
    }
    @Then("^I can see the email I have received$")
    public void checkRecept() {
    	Assert.assertTrue(WebsiteDriver.checkIfAttachment(driver, wait));
    }
    
    @Then("^I can send mail with an attachment$")
    public void mailSend() throws AWTException {
//        String password = null;
//    	if (query.contentEquals("expprofile2@gmail.com")) {
//        	password = "accountpassword2";
//        } 
//    	else if(query.contentEquals("expprofile3@gmail.com")) {
//        	password = "accountpassword3";
//    	}
//    	driver.close();
//        driver = WebsiteDriver.setUpFireFoxDriver();
//		wait = WebsiteDriver.setUpWaitDriver(driver);
//		WebsiteDriver.logInToGmail(driver, wait, query, password);
//		WebsiteDriver.openFirstMail( driver,  wait);
      
    	WebsiteDriver.sendMail(driver, wait);
    }
    
    @After()
    public void closeBrowser() {
      driver.quit();
    }
}

