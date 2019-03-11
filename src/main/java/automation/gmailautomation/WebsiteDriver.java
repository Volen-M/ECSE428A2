package automation.gmailautomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteDriver {

	public static void main(String[] args) throws InterruptedException, AWTException {
		//sendMail();
		FirefoxDriver driver = setUpFireFoxDriver();
		WebDriverWait wait = setUpWaitDriver(driver);
		
		logInToGmail(driver, wait, "expprofile1@gmail.com", "accountpassword1");
		setupMail(driver, wait, "\\img\\mcgill.jpg", "expprofile2@gmail.com", "Test_Email");
		sendMail(driver, wait);

//		driver = setUpFireFoxDriver();
//		wait = setUpWaitDriver(driver);
//		logInToGmail(driver, wait, "expprofile2@gmail.com", "accountpassword2");
//		System.out.println(checkFirstMail( driver,  wait));
		//"\\img\\mcgill.jpg"
	}
	
	public static void setupMail(FirefoxDriver driver, WebDriverWait wait, String imagePath, String emailRecipient, String emailSubject) throws InterruptedException {

		WebElement webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".T-I-KE"))));
		webEl.click();
		webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("to"))));
		webEl.sendKeys(emailRecipient);
		webEl = driver.findElement(By.name("subjectbox"));
		webEl.sendKeys(emailSubject);
		webEl = driver.findElement(By.name("Filedata"));
		String string = System.getProperty("user.dir") + imagePath;
		webEl.sendKeys(string);
		File file = new File(string);
		System.out.println(file.length()/1024);
		Thread.sleep(file.length()/1024*1000/3);


	}
	public static void sendMail(FirefoxDriver driver, WebDriverWait wait) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_CONTROL);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".b8 > div:nth-child(1) > div:nth-child(2)"))));
	}
	
	public static void openFirstMail(FirefoxDriver driver, WebDriverWait wait) {
		WebElement webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".nu > div:nth-child(1)"))));
		webEl.click();
		webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.aio:nth-child(3)"))));
		webEl.click();
		webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#\\:33 > div:nth-child(1)"))));
		webEl.click();
	}
	
	public static boolean checkIfAttachment(FirefoxDriver driver, WebDriverWait wait) {
		try {
			WebElement webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#\\:82"))));
			if (!webEl.getAttribute("src").isEmpty()) {
				return true;
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public static boolean deleteEmail(FirefoxDriver driver, WebDriverWait wait) {
		try {
		WebElement webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".iH > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1)"))));
		webEl.click();
		return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public static FirefoxDriver setUpFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", "geckodriver/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriverWait setUpWaitDriver(FirefoxDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait;
	}
	
	public static void logInToGmail(FirefoxDriver driver, WebDriverWait wait, String emailStr, String passwordStr) {
		driver.navigate().to("http://mail.google.com");
		WebElement webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("identifierId"))));
		webEl.sendKeys(emailStr);
		webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("identifierNext"))));
		webEl.click();
		webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".I0VJ4d > div:nth-child(1) > input:nth-child(1)"))));
		webEl.sendKeys(passwordStr);
		webEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#passwordNext"))));
		webEl.click();
		
	}
}
