package com.ariat.Tests.Product.WomenCategory.Countries.AddToWishList;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Pages.Products.CasualShoeProductPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Pages.Products.TriFactorTopProductPage;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageIE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearSubcategories.WomenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFootwearPage;
import com.ariat.Tests.Base.BaseTest;

/**
 * Product page - > Women Category -> Add to wishlist update, edit, set
 * priority, remove product test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class OperationsWishListWomenCategoryIETest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private HomePageIE homePageIE;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private WomenClothingTopsAndTshirtsPage womenClothingTopsAndTshirtsPage;
	private TriFactorTopProductPage triFactorTopProductPage;
	private MyWishListPage myWishListPage;
	private EUCountries euCountry;

	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private WomenFootwearCasualShoesPage womenFootwearCasualShoesCategoryPage;
	private WomenFootwearPage womenFootwearPage;
	private CasualShoeProductPage casualProductShoePage;
	private WomenCategoryPage womenCategoryPage;

	public static final String F_NAME = "Aila";
	public static final String L_NAME = "Bogasieru";
	public static final String EMAIL_WISHLIST = "aila.bogasieru@ariat.com";
    public static final String filePath= "\\Users\\Aila\\eclipse-workspace\\ariat-regression\\src\\test\\resources\\chromedriver\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", filePath);
	}

	@Test(priority = 0)
	public void productPageWomenCategoryAddToWishListShareToAFriendTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & share it to a friend test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.returningCustomer("aila.bogasieru@ariat.com", "EnglishUK");
		signInPage.returningPassword("Parola12345!");
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myWishListPage = glovesProductPage.returnMyWishListPage();
		myWishListPage.sendListToAFriend("Ana", "aila.bogasieru@yahoo.com");
		logger.info("Finishing product page -> Women Category Add to WishList & share it to a friend test.");
	}

	@Test(priority = 1)
	public void productPageWomenCategoryAddToWishListDifferentActionsTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & different actions test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.returningCustomer("aila.bogasieru@ariat.com", "EnglishUK");
		signInPage.returningPassword("Parola12345!");
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myWishListPage = glovesProductPage.returnMyWishListPage();
		myWishListPage.setPriorityWishList("Medium");
		myWishListPage.increaseQtyWishList(3);
		myWishListPage.decreaseQtyWishList(2);
		myWishListPage.editItemWishList();
		glovesProductPage.update();
		// myWishListPage.goBackFromEditToWishlist();
		logger.info("Finishing product page -> Women Category Add to WishList  & different actions test.");
	}

	@Test(priority = 2)
	public void productPageWomenCategoryAddToWishListAddToCartTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.returningCustomer("aila.bogasieru@ariat.com", "EnglishUK");
		signInPage.returningPassword("Parola12345!");
		myAccountPage = signInPage.returnMyAccountPage();
		womenClothingTopsAndTshirtsPage = homePageIE.returnWomenClothingTopsAndTshirtsPage();
		triFactorTopProductPage = womenClothingTopsAndTshirtsPage.returnTriFactorTopProductPageDE();
		triFactorTopProductPage.selectAttributeSize("Small");
		myWishListPage = triFactorTopProductPage.returnMyWishListPage();
		myWishListPage.addToCartItemWishList();
		logger.info("Finishing product page -> Women Category Add to WishList& add to cart test."
				+ homePageUK.minicartShow());

	}

	@Test(priority = 3)
	public void productPageWomenCategoryAddToWishListRemoveItemTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.returningCustomer("aila.bogasieru@ariat.com", "EnglishUK");
		signInPage.returningPassword("Parola12345!");
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myWishListPage = glovesProductPage.returnMyWishListPage();
		myWishListPage.removeItemWishList();
		logger.info("Finishing product page -> Women Category Add to WishList& add to cart test.");
		//logger.info("Finishing product page -> Women Category Add to WishList& add to cart test."
		//		+ myWishListPage.noItemWishList());
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageIE.quit();
		signInPage.quit();
		myAccountPage.quit();
		womenClothingTopsAndTshirtsPage.quit();
		myWishListPage.quit();
		triFactorTopProductPage.quit();
	}
}
