package com.ariat.Pages;

import static org.testng.Assert.assertEquals;

/**
 * 
 * This contains Return Items Page' locators, methods and links with next pages
 * @author aila.bogasieru@ariat.com
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Utils.WebDriverUtils;

public class ReturnItemsPage extends BasePage{
	
	private By returnReasonSelect = By.id("dwfrm_returns_shipments_i0_items_i0_reason");
	private By describeReasonTextBox = By.id("dwfrm_returns_shipments_i0_items_i0_reasonGiven");
	private By itemCheck = By.id("dwfrm_returns_shipments_i0_items_i0_isreturn");
	private By continueButton = By.id("okcontinue");
	private By cancelButton = By.id("cancel");
	private By errorMessageNoReason = By.xpath("//*[@id=\"newReturn\"]/div[2]");
	private By verifySalesText = By.xpath("//*contains[text(),'Verify sales return']");
	private By orderDetailsText = By.xpath("//*contains[text(),'Order Details']");
	private By quantitySelect =By.name("dwfrm_returns_shipments_i0_items_i0_quantity");
	
	
	public ReturnItemsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void checkItemClick() {
		WebDriverUtils.clickOnElementWithWait(driver, itemCheck);
	}

	public void describeReason(String reasonDescription) {
		WebDriverUtils.enterTextBox(driver, describeReasonTextBox, reasonDescription);
	}
	
	public void selectReturnReason(String reason) {
		WebDriverUtils.selectDropDown(driver, returnReasonSelect, reason);
		//WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		
	}
	
	public void selectQuantity(String quantityValue) {
		WebDriverUtils.selectDropDown(driver, quantitySelect, quantityValue);
	}
	
	public void continueClick() {
		WebDriverUtils.clickOnElement(driver, continueButton);
	}
	
	public void cancelClick() {
		WebDriverUtils.clickOnElementWithWait(driver, cancelButton);
	}
	
	public void AssertNoReason(String expectedMessage) {
		String messageLabel = WebDriverUtils.getElementText(driver, errorMessageNoReason);
		assertEquals(messageLabel, expectedMessage, "Error message displayed is: Please select at least one item you wish to return");
	}
	
	public VerifyReturnItemsPage returnVerifyReturnItemsPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, continueButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(verifySalesText));
		return new VerifyReturnItemsPage(driver);
	}
	
	public OrderDetailsPage returnOrderDetailsPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, cancelButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orderDetailsText));
		return new OrderDetailsPage(driver);
	}

}

