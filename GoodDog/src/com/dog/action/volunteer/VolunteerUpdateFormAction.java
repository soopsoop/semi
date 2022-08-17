package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.dto.volunteer.VolunteerVO;
import com.dog.service.volunteer.VolunteerService;

public class VolunteerUpdateFormAction implements Action {
	
	private VolunteerService volService;
	public void setVolunteerService(VolunteerService volService) {
		this.volService = volService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/volunteer/volUpdateForm";
		String volTitle = request.getParameter("volTitle");
		
		VolunteerVO volVO = new VolunteerVO();
		volVO.setVolTitle(volTitle);
		
		VolunteerVO volunteer = volService.getVolunteer(volTitle);
		request.setAttribute("volunteer", volunteer);
		
		System.out.println(volTitle);
		System.out.println(volunteer);
		
		return url;
	}

}
