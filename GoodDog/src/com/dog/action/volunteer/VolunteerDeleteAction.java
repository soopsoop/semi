package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.dto.volunteer.VolunteerVO;
import com.dog.service.volunteer.VolunteerService;

public class VolunteerDeleteAction implements Action {

	private VolunteerService volService;

	public void setVolunteerService(VolunteerService volService) {
		this.volService = volService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/volunteer/voldelete_success";
		String volTitle = request.getParameter("volTitle");
		System.out.println("삭제"+volTitle);
		try {
			volService.deleteVol(volTitle);
		} catch (Exception e) {
			url = "/volunteer/voldelete_fail";
			e.printStackTrace();
		}
		return url;
		
	}

}
