package com.dog.action.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;

public class ReportRegistFormAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/report/reportRegist2";
		
		return url;
	}

}
