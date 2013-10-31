package com.baranov.applogic2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.baranov.applogic.FilmHelper;
import com.baranov.model.Film;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

	public FilmHelper2(ApplicationManager2 manager) {
		super(manager.getWebDriver());
	}

	@Override
	public void create(Film film) {
		pages.internalPage.clickAddMovieLink();
		pages.filmAddPage.setTitleField(film.getTitle())
				.setYearField(film.getYear())
				.setNotesPersonalField(film.getNotes()).clickSubmitButton();

	}

	@Override
	public String delete(String filmTitle) {
		pages.internalPage.findFilm(filmTitle);
		return pages.filmViewPage.clickRemoveMovie();
	}

	@Override
	public List<String> search(String filmTitle) {
		return null;
	}

	@Override
	public String searchFilmTitle(String filmTitle) {
		List<WebElement> filmTitles = pages.internalPage.sendSearch(filmTitle);
		if (filmTitles.size() > 0) {
			return filmTitles.get(0).getText();
		}
		return null;
	}

	public String filmNotFound(String filmTitle) {
		return pages.internalPage.getError(filmTitle).getText();
	}

	public void nonCreate(Film film) {
		WebElement addMovieIcon = wait.until(ExpectedConditions
				.presenceOfElementLocated(By
						.cssSelector("img[alt=\"Add movie\"]")));
		addMovieIcon.click();
		WebElement movieName = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.name("name")));
		movieName.clear();
		movieName.sendKeys("Kill Bill: Vol. 1");
		driver.findElement(By.id("submit")).click();
		List<WebElement> allerts = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
						.xpath("//form[@id='updateform']/table/tbody/tr[4]/td[2]/label")));
		Assert.assertNotNull(allerts);
		driver.findElement(By.linkText("Home")).click();
	}

	@Override
	public boolean IsErrorsPresent() {
		return pages.filmAddPage.waitErrors();
	}

}
