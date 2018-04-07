package com.stiff.security.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginViewController 
{

	 @RequestMapping("/")
	 public String handleRoot (Model model) 
	 {
	        return "login";
	 }
	 
	 @RequestMapping("login")
	 public String handleLogin (Model model) 
	 {
	        return "login";
	 }
}
