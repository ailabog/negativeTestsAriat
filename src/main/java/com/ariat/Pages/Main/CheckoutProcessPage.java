package com.ariat.Pages.Main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * Implements checkout process page with its locators and methods
 * 
 * @author aila.bogasieru@ariat.com
 */

public class CheckoutProcessPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(CheckoutProcessPage.class);

	private By editBagLink = By.xpath("//button[@class='el-button summary__edit el-button--text']");
	private By arrowCountry = By.xpath("//span[@class='el-input__suffix']");
	private By selectOption = By.xpath("//li//span[contains(text(), 'Austria')]");
	private By selectOptionBE = By.xpath("//li//span[contains(text(), 'Belgium')]");
	private By selectOptionDE = By.xpath("//li//span[contains(text(), 'Deutschland')]");
	private By selectOptionFR = By.xpath("//li//span[contains(text(), 'Belgique')]");
	private By firstName = By.name("firstName");
	private By lastName = By.name("lastName");
	private By address = By.name("address1");
	private By address1 = By.name("address2");
	private By city = By.name("city");
	private By zipCode = By.name("zipcode");
	private By checkCheckBoxBilling = By.xpath("//input[@value='Use this address for Billing']");
	private By mobile = By.name("phone");
	private By email = By.name("email");
	private By addToAddressBoxCheck = By.xpath("//input[@vlaue='Add to Address Book']");
	private By stayInTouchCheck = By
			.xpath("//input[@value='Stay in touch. Learn about our new products and special offers first!']");
	private By continueCheckoutDE = By
			.xpath("//button[@class='el-button checkout_button el-button--primary']//span[text()='Fortsetzen']");
	private By continueCheckout1 = By.cssSelector(".el-button--primary:nth-child(1)");
	private By standardCheck = By.xpath("//input[@value='X-1']");
	private By expressCheck = By.xpath("//input[@value='U-1']");
	private By buyNowBtn = By.id("confirmpayment");
	private By checkoutCompleteText = By.xpath("//h1[text()='Checkout Complete']");
	private By giftCardTxtBox = By.xpath("//input[@placeholder=Gift Card Code']");
	private By pinTxtBox = By.xpath("//input[@placeholder='Pin']");
	private By applyGifCard = By.xpath("//button//span[text()='Apply']");
	private By promoCodeTxtBox = By.xpath("//input[@placeholder='Promo code']");
	private By expandGiftCard = By.xpath("//i[text()='Gift card']");
	private By expandPromoCode = By.xpath("//i[text()='Promo code']");
	private By selectState = By.xpath("//span[text()='Arizona']");
	private By checkoutBtn = By.xpath("//div[@data-funding-source='paypal']");
	private By nextPaymentButton = By.cssSelector(".el-button > span > span");
	private By useAddressAsItIsBtn = By.cssSelector(".ms-margin-bottom-10 > .el-button > span");
	private By closeWindowAddressBtn = By.xpath("//*[@id=\"app\"]/main/div/form/div[13]/div/div[1]/button");
	private By signInLink = By.xpath("//a[text()='Sign In']");
	private By emailMsgTxt = By.xpath("//div[@class='el-form-item__error']");

	public CheckoutProcessPage(WebDriver driver) {
		super(driver);
	}

	public void clickEditBag() {
		logger.info("Editing bag..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, editBagLink);
	}

	public void clickCheckoutBtn() {
		WebDriverUtils.scrollLittDown(driver, checkoutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, checkoutBtn);
	}

	public void selectArrow() {
		logger.info("Selecting country..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
	}

	public void selectCountry(String optionCountry) {
		switch (optionCountry) {
		case "Belgium":
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			WebDriverUtils.clickOnElementWithWait(driver, selectOptionBE);
		
		break;
		case "Deutschland":
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			WebDriverUtils.clickOnElementWithWait(driver, selectOptionDE);
			
			break;
		case "France":
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			WebDriverUtils.scroll500Down(driver, selectOptionFR);
		
			break;
		case "UK":
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			WebDriverUtils.clickOnElementWithWait(driver, selectOption);
		
			break;
		default:
			throw new RuntimeException("Language" + optionCountry + "not supported");
		}
	}

	public void selectState() {
		logger.info("Selecting state..");
		WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, selectState);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterFName(String nameValue) {
		logger.info("Entering first name..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, firstName, nameValue);
	}

	public void closeWindowAddress() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, closeWindowAddressBtn);
	}

	public void useAddressAsItIs() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, useAddressAsItIsBtn);
		}

	public void enterLName(String lastValue) {
		logger.info("Entering last name..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, lastName, lastValue);
	}

	public void enterAddress(String addressValue) {
		logger.info("Entering address address..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, address, addressValue);
	}

	public void enterAddress1(String addressValue1) {
		logger.info("Entering address1 name..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, address1, addressValue1);
	}

	public void enterCity(String cityValue) {
		logger.info("Entering city name..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, city, cityValue);
  }

	public void enterZipCode(String zipCodeValue) {
		logger.info("Entering zip code..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, zipCode, zipCodeValue);
	}

	public void checkBillingCheckBox() {
		logger.info("Checking billing address the same..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, checkCheckBoxBilling);
	}

	public void enterMobile(String mobileValue) {
		logger.info("Entering mobile phone..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, mobile, mobileValue);
	}

	public void enterEmail(String emailValue) {
		logger.info("Entering email..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, email, emailValue);
 }

	public void checkAddToAddressBox() {
		logger.info("Checking add to address box..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, addToAddressBoxCheck);
	}

	public void checkStayInTouch() {
		logger.info("Checking stay in touch checkbox..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, stayInTouchCheck);
	}

	public void continueCheckoutDE() {
		logger.info("Continue checkout..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, continueCheckoutDE);
	}

	public void continueCheckout1() {
		logger.info("Continue checkout..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, continueCheckout1);
	}

	public void checkStandardDelivery() {
		logger.info("Checking standard delivey..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, standardCheck);
	}

	public void checkExpressDelivery() {
		logger.info("Checking express delivery..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, expressCheck);
	}
	
	public void assertWrongDataCreateOrder(String emailMsgTxtValue) {
		String nameMessage = WebDriverUtils.getElementText(driver, emailMsgTxt);
		assertEquals(nameMessage, emailMsgTxtValue, "Invalid name message is displayed");
	}

	public void expandPromoCode() {
		logger.info("Expanding promo code..");
		WebDriverUtils.clickOnElementWithWait(driver, expandPromoCode);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void expandGiftCard() {
		logger.info("Expanding gift card..");
		WebDriverUtils.clickOnElementWithWait(driver, expandGiftCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void apply() {
		logger.info("Apply..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, applyGifCard);
	}

	public void enterPin(String pinValue) {
		logger.info("Entering pin..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, pinTxtBox, pinValue);
	}

	public void enterGiftCard(String giftCardValue) {
		logger.info("Entering gift card..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, giftCardTxtBox, giftCardValue);
	}

	public void clickSignIn() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, signInLink);
	}

	public void enterPromoCode(String promoCodeValue) {
		logger.info("Entering promo code..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, promoCodeTxtBox, promoCodeValue);
	}

	
	public PaymentMethodsCheckoutPage returnPaymentMethodsCheckoutPage() {
		WebDriverUtils.scroll500Down(driver, nextPaymentButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, nextPaymentButton);
		return new PaymentMethodsCheckoutPage(driver);
	}

	public CheckoutProcessCompletePage returnCheckoutProcessCompletePage() {
		WebDriverUtils.scroll500Down(driver, buyNowBtn);
		WebDriverUtils.clickOnElementWithWait(driver, buyNowBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_6000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(checkoutCompleteText));
		return new CheckoutProcessCompletePage(driver);
	}
}
