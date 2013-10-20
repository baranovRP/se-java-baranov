package com.baranov;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baranov.pages.TestBase;

public class CreateFilmTest extends TestBase {

	@Test
	public void createMovieWithValidDataTest() throws Exception {
		// driver.get(baseUrl + "/php4dvd/");
		WebElement addMovieIcon = wait.until(ExpectedConditions
				.presenceOfElementLocated(By
						.cssSelector("img[alt=\"Add movie\"]")));
		addMovieIcon.click();
		WebElement movieName = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.name("name")));
		movieName.clear();
		movieName.sendKeys("Kill Bill: Vol. 1");
		WebElement movieYear = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.name("year")));
		movieYear.clear();
		movieYear.sendKeys("2003");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.linkText("Home")).click();
	}

	@Test
	public void createMovieWithInValidDataTest() throws Exception {
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

}
