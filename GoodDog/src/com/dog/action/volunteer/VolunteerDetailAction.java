package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.action.Action;
import com.dog.dto.admin.AdminVO;
import com.dog.dto.member.MemberVO;
import com.dog.dto.volunteer.VolunteerVO;
import com.dog.service.volunteer.VolunteerService;

public class VolunteerDetailAction implements Action {
	
	private VolunteerService volService;
	public void setVolunteerService(VolunteerService volService) {
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
