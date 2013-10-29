package com.baranov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}

	public InternalPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.cssSelector("nav")));
		return this;
	}

	@FindBy(css = "nav a[href $= '?go=profile']")
	private WebElement userProfileLink;

	@FindBy(css = "nav a[href $= '?go=users']")
	private WebElement userManagementLink;

	@FindBy(css = "nav a[href $= '?logout']")
	private WebElement logoutLink;

	@FindBy(css = "nav a[href $= '?go=add']")
	private WebElement addMovieLink;

	@FindBy(css = "nav a[href $= '?go=imdbupdate']")
	private WebElement updateLink;

	@FindBy(id = "q")
	private WebElement searchField;

	By filmTitle = ByClassName.className("title");

	public List<WebElement> sendSearch(String title) {
		searchField.clear();
		searchField.sendKeys(title + Keys.RETURN);
		List<WebElement> movieTitles = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(filmTitle));
		return movieTitles;
	}

	public UserProfilePage clickUserProfilePage() {
		userProfileLink.click();
		return pages.userProfilePage;
	}

	public UserManagementPage clickUserManagementLink() {
		userManagementLink.click();
		return pages.userManagementPage;
	}

	public LoginPage clickLogoutLink() {
		logoutLink.click();
		wait.until(alertIsPresent()).accept();
		return pages.loginPage;
	}

	public FilmAddPage clickAddMovieLink() {
		addMovieLink.click();
		return pages.filmAddPage;
	}

}
