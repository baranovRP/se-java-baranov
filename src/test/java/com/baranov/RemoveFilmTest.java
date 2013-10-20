package com.baranov;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.baranov.pages.TestBase;

public class RemoveFilmTest extends TestBase {

	@Test
	public void Remove() throws Exception {
		WebElement movieTitleFirst = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.className("title")));
		movieTitleFirst.click();
		WebElement removeMovieIcon = wait
				.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector("img[alt=\"Remove\"]")));
		removeMovieIcon.click();
		assertTrue(closeAlertAndGetItsText().matches(
				"^Are you sure you want to remove this[\\s\\S]$"));
	}

}
