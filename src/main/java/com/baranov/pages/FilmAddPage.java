package com.baranov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmAddPage extends InternalPage {

	public FilmAddPage(PageManager pages) {
		super(pages);
	}

	public FilmAddPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("imdbsearchform")));
		return this;
	}

	@FindBy(name = "name")
	private WebElement titleField;

	@FindBy(name = "year")
	private WebElement yearField;

	@FindBy(name = "notes")
	private WebElement notesPersonalField;

	@FindBy(name = "submit")
	private WebElement saveButton;

	@FindBy(xpath = "//a[@href][contains(text(), 'Home')]")
	private WebElement homeLink;

	private By requiredFields = By.xpath("//input[contains(@class, 'error')]");

	public FilmAddPage setTitleField(String text) {
		titleField.clear();
		titleField.sendKeys(text);
		return this;
	}

	public FilmAddPage setYearField(String text) {
		yearField.clear();
		yearField.sendKeys(text);
		return this;
	}

	public FilmAddPage setNotesPersonalField(String text) {
		notesPersonalField.clear();
		notesPersonalField.sendKeys(text);
		return this;
	}

	public FilmViewPage clickSubmitButton() {
		saveButton.click();
		return pages.filmViewPage;
	}

	public boolean waitErrors() {
		return getWebDriver().findElements(requiredFields).size() > 0;
	}
}
