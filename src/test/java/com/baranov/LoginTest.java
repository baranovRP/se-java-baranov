package com.baranov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.baranov.pages.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void Login() throws Exception {
		driver.get(baseUrl + "/php4dvd/");
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys("admin");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.clear();
		passwordField.sendKeys("admin");
		driver.findElement(By.name("submit")).click();
	}
	
}