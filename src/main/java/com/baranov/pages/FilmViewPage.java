package com.baranov.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmViewPage extends InternalPage {
	private boolean acceptNextAlert = true;

	public FilmViewPage(PageManager pages) {
		super(pages);
	}

	@FindBy(xpath = "//a[@href][contains(text(), 'Home')]")
	private WebElement homeLink;

	@FindBy(css = "img[alt=\"Remove\"]")
	private WebElement removeFilm;

	public InternalPage clickHomeLink() {
		homeLink.click();
		return pages.internalPage;
	}

	public String clickRemoveMovie() {
		removeFilm.click();
		return closeAlertAndGetItsText();
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

}
