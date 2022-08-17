package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.command.VolRegistCommand;
import com.dog.controller.volunteer.HttpRequestParameterAdapter;
import com.dog.service.volunteer.VolunteerService;
import com.dog.vo.volunteer.VolunteerVO;

public class VolunteerCalendarRegistAction implements Action{

	private VolunteerService volService;
	public void setVolunteerService(VolunteerService volService) {
		this.volService = volService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/volunteer/volRegist_success";
		
		try {
			
			request.setCharacterEncoding("utf-8");
			VolRegistCommand command = 
					HttpRequestParameterAdapter.execute(request, VolRegistCommand.class);
			
			VolunteerVO vol = command.toVolunteerVO();
			
			
			
			System.out.println(vol.getVolTitle());
			System.out.println(vol.getVolDate());
			System.out.println(vol.getVolType());
			System.out.println(vol.getVolContent());
			
			volService.insertVol(vol);
			
		} catch (Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/volunteer/regist_fail";
		}
		
		return url;
	}

}
