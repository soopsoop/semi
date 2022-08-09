package com.dog.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;



public class LoginFormAction implements Action {


	public String process(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String url="common/loginForm";
		return url;
	}

}