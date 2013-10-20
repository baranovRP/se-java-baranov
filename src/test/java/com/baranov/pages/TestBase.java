package com.baranov.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.baranov.util.Browser;
import com.baranov.util.PropertyLoader;
import com.baranov.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 * 
 * @author Sebastiano Armeli-Battana
 */

public class TestBase {
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";

	protected WebDriver driver;

	protected WebDriverWait wait;

	protected String gridHubUrl;

	protected String baseUrl;

	protected Browser browser;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public void init() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");

		driver = WebDriverFactory.getInstance(gridHubUrl, browser, username,
				password);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	protected String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	protected boolean isElementsPresent(By locator) {
		return driver.findElements(locator).size()>0;
	}
	
	// @AfterMethod
	// public void setScreenshot(ITestResult result) {
	// if (!result.isSuccess()) {
	// try {
	// WebDriver returned = new Augmenter().augment(driver);
	// if (returned != null) {
	// File f = ((TakesScreenshot) returned)
	// .getScreenshotAs(OutputType.FILE);
	// try {
	// FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
	// + result.getName() + SCREENSHOT_FORMAT));
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// } catch (ScreenshotException se) {
	// se.printStackTrace();
	// }
	// }
	// }
}
