package com.ariat.Pages.Categories.WomenCategories.WomenSubcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesHeadwearPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesScarfAndPonchosPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesSocksPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Women Accessories Category Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenAccessoriesPage extends BasePage{
	
	private By womenAccessoriesHeadwearCategory = By.linkText("Headwear");
	private By womenAccessoriesHeadwearText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By womenAccessoriesGlovesCategory = By.linkText("Gloves");
	private By womenAccessoriesGlovesText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By womenAccessoriesBagsCategory = By.linkText("Bags");
	private By womenAccessoriesBagsText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By womenAccessoriesScarfAndPonchosCategory = By.linkText("Scarves & Ponchos");
	private By womenAccessoriesScarfAndPonchosText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By womenAccessoriesSocksCategory = By.linkText("Socks");
	private By womenAccessoriesSocksText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By womenAccessoriesGlovesLeftNav = By.linkText("Gloves");
    private By womenAccessoriesGlovesLeftNavFR = By.linkText("Gants");
    private By womenAccessoriesGlovesLeftNavDE = By.linkText("Handschuhe");
    
   		public WomenAccessoriesPage(WebDriver driver) {
		super(driver);
	}
	
		
	public WomenAccessoriesHeadwearPage returnWomenAccessoriesHeadwearCategoryPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesHeadwearCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesHeadwearText));
		return new WomenAccessoriesHeadwearPage(driver);
	}
	
	public WomenAccessoriesGlovesPage returnWomenAccessoriesGlovesCategoryPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesGlovesCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
		ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesGlovesText));
		return new WomenAccessoriesGlovesPage(driver);
	}
	
	public WomenAccessoriesGlovesPage returnWomenAccessoriesGlovesCategoryleftNavPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesGlovesLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesGlovesText));
		return new WomenAccessoriesGlovesPage(driver);
	}
	
	public WomenAccessoriesGlovesPage returnWomenAccessoriesGlovesCategoryleftNavPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesGlovesLeftNavFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesGlovesText));
		return new WomenAccessoriesGlovesPage(driver);
	}
	
	public WomenAccessoriesGlovesPage returnWomenAccessoriesGlovesCategoryleftNavPageDE() {
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesGlovesLeftNavDE);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesGlovesText));
		return new WomenAccessoriesGlovesPage(driver);
	}
	
	public WomenAccessoriesBagsPage returnWomenAccessoriesBagsCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesBagsCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesBagsText));
		return new WomenAccessoriesBagsPage(driver);
	}
	
	public WomenAccessoriesScarfAndPonchosPage returnWomenAccessoriesScarfAndPonchosCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesScarfAndPonchosCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesScarfAndPonchosText));
		return new WomenAccessoriesScarfAndPonchosPage(driver);
	}
	
	public WomenAccessoriesSocksPage returnWomenAccessoriesSocksCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenAccessoriesSocksCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesSocksText));
		return new WomenAccessoriesSocksPage(driver);
	}
}
