package com.dog.action.happydog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;


public class DogRegistFormAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/dog/dogRegist";
		return url;
	}

}