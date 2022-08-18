package com.dog.action.adoptwant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.dao.adoptwant.AdoptWantDAO;
import com.dog.dto.adoptwant.AdoptWantVO;
import com.dog.service.adoptwant.AdoptWantService;

public class AdoptWantAction implements Action {

	private AdoptWantService adoptWantService;

	public void setAdoptWantService(AdoptWantService adoptWantService) {
		this.adoptWantService = adoptWantService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/adoptwant/adoptwant_success";
		
		try {
			request.setCharacterEncoding("utf-8");
			
//			AdoptWantCommand command = HttpRequestParameterAdapter
//					.execute(request, AdoptWantCommand.class);
//			AdoptWantVO want = command.toAdoptWantVO();
			
			String wantTitle = request.getParameter("wantTitle");
			String memId = request.getParameter("memId");
			String wantContent = request.getParameter("wantContent");
			
			AdoptWantVO want = new AdoptWantVO();
			
			want.setWantTitle(wantTitle);
			want.setMemId(memId);
			want.setWantContent(wantContent);
			
			adoptWantService.regist(want);
			
		} catch (Exception e) {
			e.printStackTrace();
			url="/adoptwant/adoptwant_fail";
		}
		return url;
	}
	
}
