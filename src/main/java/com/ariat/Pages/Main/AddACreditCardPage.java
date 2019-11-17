package com.ariat.Pages.Main;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contain specific locators and methods for Add a credit card page and
 * links to
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class AddACreditCardPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(AddACreditCardPage.class);

	private By cardNickNameTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_nickname");
	private By nameOnTheCardTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_owner");
	private By typeCardSelect = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_type");
	private By cardNoTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_number");
	private By cardNoTextBoxUS = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_owner");
	private By expirationMonthSelect = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_expiration_month");
	private By expirationYearSelect = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_expiration_year");
	private By securityCodeText = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_cvn");
	private By applyButton = By.id("applyBtn");
	private By cancelButton = By.xpath("//button[text()='Cancel]");
	private By creditCardInfoText = By.xpath("//*contains[text(), 'Credit card information']");
	private By typeCardSelectUS = By.id("c-ct");
	

	public AddACreditCardPage(WebDriver driver) {
		super(driver);
	}

	public void enterCardId(String cardId) {
		logger.info("Entering card id...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNickNameTextBox, cardId);
	}

	public void enterCardOwner(String cardOwner) {
		logger.info("Entering card owner...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nameOnTheCardTextBox, cardOwner);
		}

	public void selectTypeCard(String type) {
		logger.info("Selecting the type of the card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, typeCardSelect, type);
		
	}
	
	public void selectTypeCardUS(String type) {
		logger.info("Selecting the type of the card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, typeCardSelectUS, type);
	}
	
	public void enterCardNo(String number) {
		logger.info("Selecting the type of the card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNoTextBox, number);
	}
	
	public void enterCardNoUS(String number) {
		logger.info("Selecting the type of the card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNoTextBoxUS, number);
	}

	public void selectExpirationMonthCard(String month) {
		logger.info("Selecting expiration month card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, expirationMonthSelect, month);
	}
		
	public void selectExpirationYearCard(String year) {
		logger.info("Selecting expiration year card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, expirationYearSelect, year);
		}

	public void enterSecurityCode(String cvs) {
		logger.info("Entering security code...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, securityCodeText, cvs);
	}
	

	public void applyCardCreation() {
		logger.info("Creating new credit card");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.scroll350Down(driver, applyButton);
		WebDriverUtils.clickOnElementWithWait(driver, applyButton);
	}

	public void cancelCardCreation() {
		logger.info("Canceling the card creation");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, cancelButton);
	
	}
	
     public PaymentInformationPage returnPaymentInformationPage() {
    	 WebDriverUtils.scroll350Down(driver, applyButton);
		WebDriverUtils.clickOnElementWithWait(driver, applyButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(creditCardInfoText));
		return new PaymentInformationPage(driver);
	}
}
