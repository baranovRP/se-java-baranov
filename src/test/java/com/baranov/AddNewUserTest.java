package com.baranov;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import com.baranov.model.User;
import com.baranov.pages.TestBase;

public class AddNewUserTest extends TestBase{

	@Test
	public void addNewUserOk() {
		String userName="user" + System.currentTimeMillis();
		User user = new User().setLogin(userName)
				.setPassword("password")
				.setEmail(userName+"@test.com");
		
		app.getUserHelper().loginAs(ADMIN);
		app.getUserHelper().createUser(user);
		app.getUserHelper().logout();
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().isLoggedInAs(user));
		

	}
}
