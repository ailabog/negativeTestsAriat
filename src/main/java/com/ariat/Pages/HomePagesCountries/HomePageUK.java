
package com.ariat.Pages.HomePagesCountries;

import static org.testng.Assert.assertEquals;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Header.FindARetailerPage;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.MyAccountWishListPage;
import com.ariat.Pages.Products.CasualShoeProductPage;
import com.ariat.Utils.WebDriverUtils;

public class HomePageUK extends BasePage implements List<HomePage> {

	public HomePageUK(WebDriver driver) {
		super(driver);
	}

	private static final Logger logger = LoggerFactory.getLogger(HomePageUK.class);

	private By signIn = By.xpath("//a[text()='Sign In']");
	private By womenCategory = By.xpath("//*[@id=\"global-nav-container\"]/li[1]/a");
	private By ourStoryImg = By.linkText("//img[contains(@href, 'We-Believe_973x1193px_3.jpg']");
	private By returningCustomerText = By.xpath("//*text()='Returning customer']");
	private By checkOrderText = By.xpath("//*text()='Check an order / request return']");
	private By newcustomerText = By.xpath("//*text()='New Customer']");
	private By womenText = By.xpath("//*contains(text(),'Women']");
		
	private By findARetailerFooter = By.xpath("//a[contains(text(),'Find a Retailer')]");
	private By findARetailerText = By.xpath("//h1[text()='Find a retailer']");
	private By wishListFooter = By.xpath("(//a[contains(text(),'Wishlist')])[2]");
	private By wishListText = By.xpath("//h1[text()='My account']");
	private By wishListText1 = By.xpath("//h2[text()='Wishlist']");
	private By search = By.xpath("//*[@id=\"header-main-content\"]/div/div[5]/div/div[1]/span[2]");
	private By searchTextBox = By.xpath("//input[@placeholder='Search for Products']");
	private By textMsgProduct = By.xpath("//*[@id=\"search-suggestions-results\"]/div/div[1]/div[1]");
	private By seeAllproductsLink = By.xpath("//*[@id=\"search-suggestions-results\"]/div/div[1]/div[2]/a");
	private By closeSearch = By.xpath("//*[@id=\"header-main-content\"]/div/div[6]/div[2]/form/div/div[1]/span/span");
	private By womenFootwearCasualShoesCategory = By.xpath("//*[@id=\"global-nav-container\"]/li[1]/div[2]/div/div[2]/ul[1]/li/ul/li[5]/a]");
	private By womenAccessoriesText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By accessoriesCategory = By.xpath("//a[text()='Accessories']");
	private By minicartDialog = By.id("mini-cart-products-ariat");
	private boolean showMinicart;
	private By myAccountFooter = By.xpath("//a[contains(text(),'My Accounts')]");
	private By myAccountText = By.xpath("//h2[text()='Returning customer']");
	private By aboutUsHeader = By.linkText("About Us");
	private By ridingCategory = By.xpath("//*[@id=\"global-nav-container\"]/li[1]/div[2]/div/div[2]/ul[1]/li/ul/li[1]/a");


	public void search(String option) {
		logger.info("Searching for a product...");
		WebDriverUtils.clickOnElementWithWait(driver, search);
		WebDriverUtils.enterTextBox(driver, searchTextBox, option);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void assertProductDisplayed(String expectedText) {
		String text = WebDriverUtils.getElementText(driver, textMsgProduct);
		assertEquals(text, expectedText, "Product results for:" + text);
	}

	public void seeAllproducts() {
		logger.info("Display all the products...");
		WebDriverUtils.clickOnElementWithWait(driver, seeAllproductsLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void closeSearch() {
		logger.info("Close serach products...");
		WebDriverUtils.clickOnElementWithWait(driver, closeSearch);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public SignInPage returnSignInPage() {
		WebDriverUtils.clickOnElementWithWait(driver, signIn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(returningCustomerText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(checkOrderText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(newcustomerText));
		return new SignInPage(driver);
	}

	public WomenCategoryPage returnWomenCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenText));
		return new WomenCategoryPage(driver);
	}
	
	public WomenCategoryPage returnWomenCategoryPageRiding() {
		WebDriverUtils.moveToElement(driver, womenCategory);
		WebDriverUtils.clickOnElementWithWait(driver, ridingCategory);
		return new WomenCategoryPage(driver);
	}

	public FindARetailerPage returnFindARetailer() {
		WebDriverUtils.scrollBottomPage(driver, findARetailerFooter);
		WebDriverUtils.clickOnElementWithWait(driver, findARetailerFooter);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(findARetailerText));
		return new FindARetailerPage(driver);
	}

	public SignInPage returnSignInPageFromFooter() {
		WebDriverUtils.scrollBottomPage(driver, myAccountFooter);
		WebDriverUtils.clickOnElementWithWait(driver, myAccountFooter);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		return new SignInPage(driver);
	}

	public MyAccountWishListPage returnMyAccountWishListPage() {
		WebDriverUtils.scrollBottomPage(driver, wishListFooter);
		WebDriverUtils.clickOnElementWithWait(driver, wishListFooter);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(wishListText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(wishListText1));
		return new MyAccountWishListPage(driver);
	}

	public boolean minicartShow() {
		if (WebDriverUtils.findElement(driver, minicartDialog) != null) {
			showMinicart = true;
			logger.info("Product was added in cart from WishList" + showMinicart);
		}
		return showMinicart;
	}

	public CasualShoeProductPage returnCasualShoeProductPage() {
		WebDriverUtils.moveToElement(driver, womenCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenFootwearCasualShoesCategory));
		return new CasualShoeProductPage(driver);
	}

	public WomenAccessoriesPage returnAccessoriesCategoryPage() {
		WebDriverUtils.moveToElement(driver, womenCategory);
		WebDriverUtils.clickOnElement(driver, accessoriesCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenAccessoriesText));
		return new WomenAccessoriesPage(driver);
	}

	@Override
	public boolean add(HomePage e) {

		return false;
	}

	@Override
	public void add(int index, HomePage element) {

	}

	@Override
	public boolean addAll(Collection<? extends HomePage> c) {

		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends HomePage> c) {

		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean contains(Object o) {

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return false;
	}

	@Override
	public HomePage get(int index) {

		return null;
	}

	@Override
	public int indexOf(Object o) {

		return 0;
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public Iterator<HomePage> iterator() {

		return null;
	}

	@Override
	public int lastIndexOf(Object o) {

		return 0;
	}

	@Override
	public ListIterator<HomePage> listIterator() {

		return null;
	}

	@Override
	public ListIterator<HomePage> listIterator(int index) {

		return null;
	}

	@Override
	public boolean remove(Object o) {

		return false;
	}

	@Override
	public HomePage remove(int index) {

		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		return false;
	}

	@Override
	public HomePage set(int index, HomePage element) {

		return null;
	}

	@Override
	public int size() {

		return 0;
	}

	@Override
	public List<HomePage> subList(int fromIndex, int toIndex) {

		return null;
	}

	@Override
	public Object[] toArray() {

		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {

		return null;
	}
}
