package com.ariat.Pages.Main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * Implements checkout process complete page with its locators and methods
 * 
 * @author aila.bogasieru@ariat.com
 */

public class CheckoutProcessCompletePage extends BasePage{
	
	private static final Logger logger = LoggerFactory.getLogger(CheckoutProcessCompletePage.class);
	
	private By subscribeToNewsletterCheck = By.xpath("//input[@value='Subscribe to our Newsletter']");
	private By submitBtn = By.xpath("//button[@class='el-button btn btn-primary submit-newsletter-btn el-button--primary']");
	private By createPassword = By.xpath("//input[@placeholder='Create a password']");
	private By createPasswordDE = By.xpath("//input[@placeholder='Passwort erstellen']");
	private By confirmPassword = By.xpath("//input[@placeholder='Confirm password']");
	private By confirmPasswordDE = By.xpath("//input[@placeholder='Passwort bestatigend']");
	private By createAccountBtn = By.xpath("/span[text()='Create an account']");
	private By createAccountBtnDE = By.xpath("//span[contains(text(), 'Konto erstellen')]");
	private By printThisPageLink = By.xpath("//span[text()='Print This Page']");
	private By itemText = By.xpath("//a[@title='FEI WC Bodymap Softshell Jkt']");
	private By myAccountText = By.xpath("//h1[text()='My account']");
	private By errorMsgPlaceOrder = By.xpath("//div[@class='opc-error-msg el-col el-col-12']");
	private By buyNowBtn = By.xpath("//*[@id=\"paymentbtncs\"]");
	private By pressPayPalCheckout = By.xpath("//iframe[@class='zoid-component-frame zoid-visible']");
	

	protected CheckoutProcessCompletePage(WebDriver driver) {
		super(driver);
	}
	
	public void subscribeNewsletter() {
		logger.info("Subscribing to newsletter..");
		WebDriverUtils.clickOnElementWithWait(driver, subscribeToNewsletterCheck);
	}
	
	public void placeOrder() {
		WebDriverUtils.scroll350Down(driver, buyNowBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, buyNowBtn);
 }
	
	public void submitingSubscription() {
		logger.info("Submiting subscription to newsletter..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, submitBtn);
	}
	
	public void enterPassword(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, createPassword, createPasswordValue);
	}
	
	public void enterPasswordDE(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, createPasswordDE, createPasswordValue);
	}
	
	public void confirmPassword(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, confirmPassword, createPasswordValue);
	}
	
	public void confirmPasswordDE(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, confirmPasswordDE, createPasswordValue);
	}
	
	public void createAccount() {
		logger.info("Create account..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, createAccountBtn);
	}
	
	public void createAccountDE() {
		logger.info("Create account..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, createAccountBtnDE);
	}
	
	public void printOrder() {
		logger.info("Print oder information..");
		WebDriverUtils.clickOnElementWithWait(driver, printThisPageLink);
	}
	
	public void checkItem() {
		logger.info("Check that item order is the right one..");
		WebDriverUtils.clickOnElementWithWait(driver, itemText);
	}
	
	public void pressPayPalCheckout() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, pressPayPalCheckout);
	}
	
	public void assertErrMsgOrderNotPlaced(String expectedErrorMsg) {
		logger.info("Check that error message is diplayed..");
		String errMsg = WebDriverUtils.getElementText(driver, errorMsgPlaceOrder);
		assertEquals(errMsg, expectedErrorMsg, "Error message with not being placed the order is displayed");
	}
	
	
	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.clickOnElementWithWait(driver, createAccountBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		return new MyAccountPage(driver);
	}
}
