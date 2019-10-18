package com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.WomenCategories.HeritageProductPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Utils.WebDriverUtils;


/**
 * Implements Women Footwear Riding Category Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenFootwearRidingPage extends BasePage{
	
	private By heritage = By.cssSelector("#\\37 1c529871b0e23de6cda26efe7 .psd-4-full-width-video-module-1__image");
	private By heritageText = By.xpath("//*[contains(text(), Capriole Tall Riding Boot']");
	
	public WomenFootwearRidingPage(WebDriver driver) {
		super(driver);
	}
	
	public HeritageProductPage returnHeritageProduct() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, heritage);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(heritageText));
		return new HeritageProductPage(driver);
	}
	
	
}
