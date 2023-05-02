package com.linedata.project.management.std.services.serviceapi;
import org.springframework.security.provisioning.UserDetailsManager;

public interface UserService extends UserDetailsManager{

	boolean validateUser(String username,String password);

}
