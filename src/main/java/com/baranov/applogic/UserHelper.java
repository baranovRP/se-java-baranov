package com.baranov.applogic;

import com.baranov.model.User;

public interface UserHelper {

	void loginAs(User user);

	void logout();

	boolean isLoggedIn();

	boolean isLoggedInAs(User user);

	boolean isNotLoggedIn();

	void createUser(User user);

}
