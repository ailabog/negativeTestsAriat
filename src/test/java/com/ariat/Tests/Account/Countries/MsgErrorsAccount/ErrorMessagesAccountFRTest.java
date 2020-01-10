package com.ariat.Tests.Account.Countries.MsgErrorsAccount;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;


/**
 * Negative tests for France account
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ErrorMessagesAccountFRTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageFR homePageFR;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;


	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String BIRTH_MONTH = "Mars";
	public static final String BIRTH_DAY = "02";
	public static final String EMAIL = GenerateRandomDataUtils.generateRandomAlphaNumeric(7);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomNumber(3);
	public static final String ORDER_NO = GenerateRandomDataUtils.generateRandomAlphaNumeric(4);
	public static final String BILLING_ZIP_CODE = GenerateRandomDataUtils.generateRandomString(3);
	public static final String ERROR_MESSAGE = "Désolé, ce numéro de commande ou code postal ne correspond pas à celui que nous avons dans nos dossiers. Vérifiez-le puis réessayez.";
	public static final String INVALID_EMAIL_MSG = "L'adresse courriel n'est pas valide.";
	public static final String INVALID_PASS_MSG = "(8 - 255 characters)";
	public static final String MISMATCH_PASS_MSG = "Désolé, ceci ne correspond pas aux infos que nous avons dans nos dossiers. Vérifiez l'orthographe puis réessayez.";
	public static final String WRONG_EMAIL = "aaaa@yahoo.com";
	public static final String OK_EMAIL = "aila.bogasieru@ariat.com";
	public static final String WRONG_PASSWORD = "Password";
	public static final String OK_PASSWORD = "Parola12345!";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}


	@Test(priority = 0)
	public void returningCustomerWrongPasswordTest() {
		logger.info("Starting returning customer wrong password test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(OK_EMAIL, "Francais", WRONG_PASSWORD);
		signInPage.loginClick();
		signInPage.assertWrongPasswordMessage(MISMATCH_PASS_MSG);
		logger.info("Finishing returning customer wrong password test...");
	}
	
	@Test(priority = 1)
	public void returningCustomerWrongEmailTest() {
		logger.info("Starting returning customer wrong email test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(WRONG_EMAIL, "Francais", OK_PASSWORD);
		signInPage.loginClick();
		signInPage.assertWrongEmailMessage(MISMATCH_PASS_MSG);
		logger.info("Finishing returning customer wrong email test...");
	}

	
	@Test(priority = 2)
	public void returningCustomerTest() {
		logger.info("Starting returning customer test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(OK_EMAIL, "Francais", OK_PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.logoutMiddle();
		logger.info("I was succesfully logged out from the application!");
	}
	
	@AfterTest
	public void clearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		homePageFR.quit();
		signInPage.quit();
		myAccountPage.quit();
		KillChrome kill = new KillChrome();
	}
}
