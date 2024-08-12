package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	 @Autowired
		private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
			super();
			this.authenticationService = authenticationService;
		}
	
	@RequestMapping(value="login",method =RequestMethod.GET)
	public String loginPage() {
		
		return "loginPage";
	}
	@RequestMapping(value="login",method =RequestMethod.POST)
	public String gotowelcomePage(@RequestParam String name,
			@RequestParam String password,ModelMap model ) {
		if(authenticationService.authenticate(name, password)) {
			
		
		model.put("password", password);
		model.put("name", name);
		return "welcomePage";
		}
		model.put("errorMessage", "Invalid Credentials.Please try again.");
		
		return "loginPage";
	}
}

