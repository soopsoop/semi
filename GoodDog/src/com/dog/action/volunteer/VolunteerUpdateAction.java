package com.dog.action.volunteer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.dto.volunteer.VolunteerVO;
import com.dog.service.volunteer.VolunteerService;

public class VolunteerUpdateAction implements Action {
	private VolunteerService volService;
	public void setVolunteerService(VolunteerService volService) {
		this.volService = volService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/volunteer/volUpdate_success";
		
		request.setCharacterEncoding("UTF-8");
		
		String volTitle = request.getParameter("volTitle");
		String volDate = request.getParameter("volDate");
		String volType = request.getParameter("volType");
		String volContent = request.getParameter("volContent");
		
		VolunteerVO volVO = new VolunteerVO();
		volVO.setVolTitle(volTitle);
		volVO.setVolDate(volDate);
		volVO.setVolType(volType);
		volVO.setVolContent(volContent);
		
		volService.updateVol(volVO);
		System.out.println("수정" + volTitle);
		System.out.println("수정" + volDate);
		System.out.println("수정" + volType);
		System.out.println("수정" + volContent);
		
		return url;
	}

}
