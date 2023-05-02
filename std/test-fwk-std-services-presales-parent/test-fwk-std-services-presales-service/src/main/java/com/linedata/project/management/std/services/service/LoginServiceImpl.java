package com.linedata.project.management.std.services.service;
/*
import javax.annotation.Resource;
*/
import org.springframework.stereotype.Service;

import com.linedata.project.management.std.services.serviceapi.LoginService;
import com.linedata.project.management.std.services.serviceapi.UserService;

@Service
public class LoginServiceImpl implements LoginService {

	//@Resource(name="UserDetailsManagerImpl")
	private UserService detailsManagerImpl;
	
	public boolean validate(String user, String password) {

		if (detailsManagerImpl.validateUser(user, password))
			return true;
		else
			return false;
	}
}
