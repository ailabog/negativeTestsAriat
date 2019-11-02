package com.ariat.Tests.Checkout.NegativeCreateOrder;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageSE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Checkout -> Negative Create new order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeCheckoutCreateOrderSETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
    private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private HomePageSE homePageSE;

	public static final String CARD_NAME_NOK = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String FIRST_NAME_NOK = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String LAST_NAME_NOK = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS_NOK = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITY_NOK = "24534543";
	public static final String CITY_OK = "Frankfurt";
	public static final String COUNTRY_OK = "Deutschland";
	public static final String ZIP_CODE_NOK = GenerateRandomDataUtils.generateRandomString(5);
	public static final String MOBILE_NOK = GenerateRandomDataUtils.generateRandomString(7);
	public static final String EMAIL_NOK = GenerateRandomDataUtils.generateRandomNumber(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);
	public static final String EMAILEXISTENT = "aila.bogasieru@ariat.com";
	public static final String PASSWORDEXISTENT = "Parola12345!";
	public static final String CARD_NAME_OK = GenerateRandomDataUtils.generateRandomString(5);
	public static final String FIRST_NAME_OK = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME_OK = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS_OK = GenerateRandomDataUtils.generateRandomString(5);

	public static final String ZIP_CODE_OK = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String MOBILE_OK = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ERROR_ORDER_NOT_PLACED ="We're sorry that your order could not be placed. This probably happened due to a high order volume or temporary connection errors. Please wait a few minutes and resubmit your order. We won't process your payment until you successfully place your order. If you have further questions, please contact us.";
	public static final String ERROR_MESAGE = "Please enter a valid value";
	

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority=0)
	public void checkoutNegativeCreateOrderInvalidContactInfoAndShippingAddress() {
		logger.info("Starting checkout -> create negative order invalid shipping address...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageSE = (HomePageSE) homePage.chooseEULocation(euCountry.SE, euCountry.SE.getCurrencyISO());
		womenCategoryPage = homePageSE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPageDE();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPageDE();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME_NOK);
		checkoutProcessPage.enterLName(LAST_NAME_NOK);
		checkoutProcessPage.assertWrongDataCreateOrder(ERROR_MESAGE);
		checkoutProcessPage.enterAddress(ADDRESS_NOK);
		checkoutProcessPage.assertWrongDataCreateOrder(ERROR_MESAGE);
		checkoutProcessPage.enterAddress1(ADDRESS_NOK);
		checkoutProcessPage.assertWrongDataCreateOrder(ERROR_MESAGE);
		checkoutProcessPage.enterCity(CITY_NOK);
		checkoutProcessPage.enterZipCode(ZIP_CODE_NOK);
		checkoutProcessPage.assertWrongDataCreateOrder(ERROR_MESAGE);
		checkoutProcessPage.selectArrow();
		checkoutProcessPage.selectCountry("UK");
		checkoutProcessPage.enterMobile(MOBILE_NOK);
		checkoutProcessPage.assertWrongDataCreateOrder(ERROR_MESAGE);
		checkoutProcessPage.enterEmail(EMAIL_NOK);
		checkoutProcessPage.assertWrongDataCreateOrder(ERROR_MESAGE);
		logger.info("Finishing checkout -> create negative order invalid shipping address.");
	}

	
	
	@AfterTest
	public void clearBrowserSession() {
		KillChrome kill = new KillChrome();
    }

	@AfterSuite
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageSE.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		glovesProductPage.quit();
		myBagPage.quit();
		checkoutPage.quit();
		checkoutProcessPage.quit();
	}
}
