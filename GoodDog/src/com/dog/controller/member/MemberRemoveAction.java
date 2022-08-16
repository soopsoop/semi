package com.dog.controller.member;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.action.Action;
import com.dog.controller.GetUploadPath;
import com.dog.vo.member.MemberVO;
import com.dog.service.member.MemberService;

public class MemberRemoveAction implements Action {

	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/remove_success";

		String memId = request.getParameter("memId");

		MemberVO member = memberService.getMember(memId);

		// DB �궘�젣
		memberService.remove(memId);

		// loginUser �솗�씤
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser != null && member.getMemId().equals(loginUser.getMemId())) {
			session.invalidate();
		}

		request.setAttribute("member", member);

		return url;
	}

}
