package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;

public class VolunteerCalendarRegistFormAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/volunteer/volRegist";
		return url;
	}

}
