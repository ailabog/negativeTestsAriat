package com.ariat.Pages.Main;


import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Utils.WebDriverUtils;

/**
 * Contain locators and methods for My Orders page and links with Order details
 * and Return Policy pages
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyOrdersPage extends BasePage {

	private By returnPolicyLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/a");
	private By orderDetailsText = By.xpath("//*[contains[text(),'Order Details']");
	private By returnsPolicyText = By.xpath("//*contains[text(),'Returns']");
	private By orderNoText = By.xpath("//*[@id=\"order-items\"]/div[1]/div[3]/a");
	private By totalOrder = By.xpath("//*[@id=\"order-items\"]/div[1]/div[2]/div[3]/span");
    private By statusOrder = By.xpath("//*[@id=\"order-items\"]/div[1]/div[1]/div[3]/span[2]");
	private By dateOrder = By.xpath("//*[@id=\"order-items\"]/div[1]/div[1]/div[2]/span[2]");

	public MyOrdersPage(WebDriver driver) {
		super(driver);
	}

	public OrderDetailsPage returnOrderDetailsPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, orderNoText);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orderDetailsText));
		return new OrderDetailsPage(driver);
	}

	public void searchOrderNo(String expectedOrderNo) {
		WebDriverUtils.clickOnElementWithWait(driver, orderNoText);
	
	}
	
	public void assertInfoOrderMyOrder(String expectedDate, String expectedStatus, String expectedTotal) {
				
		String dateNoLabel = WebDriverUtils.getElementText(driver, dateOrder);
		assertEquals(expectedDate, dateNoLabel, "Date is as expected");
		
		String statusLabel = WebDriverUtils.getElementText(driver, statusOrder);
		assertEquals(expectedStatus, statusLabel, "Status is as expected");
		
		String totalLabel = WebDriverUtils.getElementText(driver, totalOrder);
		assertEquals(expectedTotal, totalLabel, "Total is as expected");
	}
}
