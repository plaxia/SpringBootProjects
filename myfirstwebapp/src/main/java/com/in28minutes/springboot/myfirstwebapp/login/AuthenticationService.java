package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
		public boolean authenticate(String username,String password) {
			
			boolean isValidUsername = username.equalsIgnoreCase("ruhi");
			boolean isValidPassword = password.equalsIgnoreCase("ruhi123");
			
			return  isValidUsername && isValidPassword  ;
		}
	
}
