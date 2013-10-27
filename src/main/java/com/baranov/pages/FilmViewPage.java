package com.baranov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmViewPage extends InternalPage{

	public FilmViewPage(PageManager pages) {
		super(pages);
	}
	
	@FindBy(xpath = "//a[@href][contains(text(), 'Home')]")
	private WebElement homeLink;
	
	public InternalPage clickHomeLink() {
		homeLink.click();
		return pages.internalPage;
	}
}
