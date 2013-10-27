package com.baranov;

import static org.testng.AssertJUnit.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baranov.model.Film;
import com.baranov.pages.TestBase;

public class CreateFilmTest extends TestBase {

	@Test
	public void createMovieWithValidDataTest() throws Exception {
		Film film = new Film().withTitle(generateRandomString())
				.withYear(generateRandomYear())
				.withNotes(System.currentTimeMillis() + "");
		app.getUserHelper().loginAs(ADMIN);
		app.getFilmHelper().create(film);
	}

	@Test
	public void createMovieWithInValidDataTest() throws Exception {
		Film film = new Film().withYear(generateRandomYear()).withNotes(
				System.currentTimeMillis() + "");
		app.getUserHelper().loginAs(ADMIN);
		app.getFilmHelper().create(film);
		assertTrue(app.getFilmHelper().IsErrorsPresent());
	}

}
