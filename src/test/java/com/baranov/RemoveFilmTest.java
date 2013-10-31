package com.baranov;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import com.baranov.pages.TestBase;

public class RemoveFilmTest extends TestBase {

	@Test
	public void Remove() throws Exception {
		String title = "Kill Bill";
		app.getUserHelper().loginAs(ADMIN);
		assertTrue(app.getFilmHelper().delete(title)
				.matches("^Are you sure you want to remove this[\\s\\S]$"));
	}

}
