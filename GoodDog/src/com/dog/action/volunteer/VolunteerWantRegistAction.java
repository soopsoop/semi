package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.controller.HttpRequestParameterAdapter;
import com.dog.service.volunteer.VolunteerService;
import com.dog.vo.volunteer.VolunteerVO;

public class VolunteerWantRegistAction implements Action {
	
	private VolunteerService volService;
	public void setMemberService(VolunteerService volService) {
		this.volService = volService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/volunteer/wantRegist_success";
		String volTitle = request.getParameter("volTitle");
		String memId="aa";
		//임의지정.원래는 session에서 로그인 회원 정보를 가져와야함.
		
		
		//입력
		try {
			request.setCharacterEncoding("utf-8");
			VolunteerVO volVO = new VolunteerVO();
			volVO.setMemId(memId);
			volVO.setVolTitle(volTitle);
			System.out.println("cnt");
			System.out.println(volVO.getMemId());
			System.out.println(volVO.getVolTitle());
			int cnt = volService.insertVolWantMember(volVO);
		
		
		}catch(Exception e) {
			e.printStackTrace();
			url="/volunteer/wantRegist_fail";
		}
		
		return url;
	}

}
