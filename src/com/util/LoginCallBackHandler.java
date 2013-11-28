package com.util;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class LoginCallBackHandler implements CallbackHandler {

	private String username;

	/**
	 * 
	 * Password which will be set in the PasswordCallback, when PasswordCallback
	 * is handled
	 */
	private String password;

	/**
	 * 
	 * Constructor
	 * 
	 * @param username
	 *            The username
	 * 
	 * @param password
	 *            The password
	 */

	public LoginCallBackHandler(String username, String password) {

		this.username = username;

		this.password = password;

	}

	/**
	 * 
	 * @param callbacks
	 *            Instances of Callbacks
	 * 
	 * @throws IOException
	 *             IOException
	 * 
	 * @throws UnsupportedCallbackException
	 *             If Callback is other than NameCallback or PasswordCallback
	 */
	public void handle(Callback callbacks[]) throws IOException,
			UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++) {

			if (callbacks[i] instanceof NameCallback) {

				NameCallback nc = (NameCallback) callbacks[i];

				nc.setName(username);

				System.out.println("USER NAME:: " + username);
			}

			else if (callbacks[i] instanceof PasswordCallback) {

				PasswordCallback pc = (PasswordCallback) callbacks[i];

				pc.setPassword(password.toCharArray());

				System.out.println("PASSWORD:: " + password);
			}

			else {
				throw new UnsupportedCallbackException(callbacks[i],
						"Unrecognized Callback");

			}

		}

	}

}