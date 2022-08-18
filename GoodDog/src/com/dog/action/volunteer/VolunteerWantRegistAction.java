package com.dog.action.volunteer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.action.Action;
import com.dog.dto.member.MemberVO;
import com.dog.dto.volunteer.VolunteerVO;
import com.dog.service.volunteer.VolunteerService;

public class VolunteerWantRegistAction implements Action {

	private VolunteerService volService;

	public void setVolunteerService(VolunteerService volService) {
		this.volService = volService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/volunteer/wantRegist_success";
		String volTitle = request.getParameter("volTitle");

		HttpSession session = request.getSession();

			// 입력
			try {
				MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
				String loginId = loginUser.getMemId();
				System.out.println(loginId);
				request.setCharacterEncoding("utf-8");
				VolunteerVO volVO = new VolunteerVO();
				volVO.setMemId(loginId);
				volVO.setVolTitle(volTitle);
				System.out.println(volVO.getMemId());
				System.out.println(volVO.getVolTitle());
				volService.insertVolWantMember(volVO);

			} catch (Exception e) {
				url = "/volunteer/wantRegist_fail";
//				throw e;
				e.printStackTrace();
				System.out.println("비로그인");
			}

		return url;
	}

}
