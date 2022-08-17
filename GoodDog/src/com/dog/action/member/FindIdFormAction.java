package com.dog.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindIdFormAction {
	public String process(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String url="/common/findidform";
		return url;
	}
}
