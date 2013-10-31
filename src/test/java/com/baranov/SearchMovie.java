package com.baranov;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baranov.pages.TestBase;

public class SearchMovie extends TestBase {

	@Test
	public void searchFound() throws Exception {
		String title = "Kill Bill";
		app.getUserHelper().loginAs(ADMIN);
		Assert.assertTrue(app.getFilmHelper().searchFilmTitle(title)
				.contains(title));
	}

	@Test
	public void searchNotFound() throws Exception {
		String title = "9999";
		String errorMsg = "No movies where found.";
		app.getUserHelper().loginAs(ADMIN);
		Assert.assertTrue(app.getFilmHelper().filmNotFound(title)
				.equalsIgnoreCase(errorMsg));
	}

}
