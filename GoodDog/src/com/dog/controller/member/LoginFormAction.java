package com.dog.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginFormAction {


	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url="common/loginForm";
		return url;
	}

}