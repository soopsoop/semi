package com.dog.action.volunteer;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.service.volunteer.VolunteerService;
import com.dog.vo.volunteer.VolunteerVO;

public class VolTitleCheckAction implements Action {
	private VolunteerService volService;
	public void setMemberService(VolunteerService volService) {
		this.volService = volService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		String title = request.getParameter("title");
		
		String resultStr = "";
		
		try {
			VolunteerVO volunteer = volService.getVolunteer(title);
			if (volunteer != null) {
				resultStr="DUPLICATED";	
			}
			
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(resultStr);
			out.close();
			
		} catch (Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		return url;
	}

}
