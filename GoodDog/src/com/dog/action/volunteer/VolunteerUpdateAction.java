package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.service.volunteer.VolunteerService;

public class VolunteerUpdateAction implements Action {
	private VolunteerService volService;
	public void setVolunteerService(VolunteerService volService) {
		this.volService = volService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

}
