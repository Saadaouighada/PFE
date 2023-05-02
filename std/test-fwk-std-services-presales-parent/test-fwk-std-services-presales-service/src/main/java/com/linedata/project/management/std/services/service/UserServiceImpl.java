package com.linedata.project.management.std.services.service;


//@Service
public class UserServiceImpl /*implements UserService */{

	public boolean validateUser(String user, String pwd) {
		Boolean res = false;

		if (user == "ekip" && pwd == "ekip")
			return true;
		else
			return res;
	}
}