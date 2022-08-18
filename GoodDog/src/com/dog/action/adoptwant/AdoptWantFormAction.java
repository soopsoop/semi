package com.dog.action.adoptwant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;

public class AdoptWantFormAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/adoptwant/adoptwant";
		return url;
	}

	
}
