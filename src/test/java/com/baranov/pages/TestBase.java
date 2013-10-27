package com.baranov.pages;

import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.baranov.applogic.ApplicationManager;
import com.baranov.applogic2.ApplicationManager2;
import com.baranov.model.User;

public class TestBase {

	public static User ADMIN = new User().setLogin("admin")
			.setPassword("admin");
	protected ApplicationManager app;

	public String generateRandomYear() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "";
		}	else {
			int year = 1000 + rnd.nextInt(1014);
			return "" + year;
		}
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "";
		}	else {
			return "test" + rnd.nextInt();
		}
	}
	
	@BeforeClass
	public void init() {
		app = new ApplicationManager2();
	}

	@AfterSuite
	public void stop() {
		app.stop();
	}

}
