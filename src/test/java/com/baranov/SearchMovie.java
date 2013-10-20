package com.baranov;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baranov.pages.TestBase;

public class SearchMovie extends TestBase {

	@Test
	public void searchFound() throws Exception {
		WebElement searchField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("q")));
		searchField.clear();
		searchField.sendKeys("kill" + Keys.RETURN);
		List<WebElement> movieTitles = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.className("title")));
		Assert.assertNotNull(movieTitles);
	}

	@Test
	public void searchNotFound() throws Exception {
		WebElement searchField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("q")));
		searchField.clear();
		searchField.sendKeys("9999" + Keys.RETURN);
		WebElement moviesNotFound = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.className("content")));
		moviesNotFound.getText();
		Assert.assertEquals(
				true,
				moviesNotFound.getText().equalsIgnoreCase(
						"No movies where found."));
	}

}
