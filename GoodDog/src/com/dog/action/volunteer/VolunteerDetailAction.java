package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.service.volunteer.VolunteerService;
import com.dog.vo.volunteer.VolunteerVO;

public class VolunteerDetailAction implements Action {
	
	private VolunteerService volService;
	public void setMemberService(VolunteerService volService) {
		this.volService = volService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/volunteer/detail";
		String volTitle = request.getParameter("volTitle");
		
		VolunteerVO volunteer = volService.getVolunteer(volTitle);
		request.setAttribute("volunteer", volunteer);
		
		System.out.println(volTitle);
		System.out.println(volunteer);
		
		return url;
		
	}

}
