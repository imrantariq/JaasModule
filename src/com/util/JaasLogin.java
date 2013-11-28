package com.util;

import javax.security.auth.login.LoginException;
import org.jboss.security.auth.spi.UsersRolesLoginModule;

public class JaasLogin extends UsersRolesLoginModule {
	public boolean login() throws LoginException {
		System.out.println("going to login.");
		return super.login();
	}
}