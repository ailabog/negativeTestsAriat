package com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearSubcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Women Footwear CasualShoes Category Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenFootwearCasualShoesPage extends BasePage{
	
	private By casualShoeFuse = By.xpath("//*[@id=\"424eebcf34f27da1d56bc5e306\"]/div[1]/a/picture/img");
	private By fuseText = By.xpath("//*contains[text()='Fuse']");

	public WomenFootwearCasualShoesPage(WebDriver driver) {
		super(driver);
	}
	
	public CasualShoeProductPage returnCasualShoeProductPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, casualShoeFuse);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(fuseText));
		return new CasualShoeProductPage(driver);
	}

}
