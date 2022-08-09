package com.dog.controller.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.service.member.MemberService;



public class LoginHandler implements Handler {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = "redirect:index.do";
		
		// 로그인 처리
		String memId = request.getParameter("id");
		String memPw = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			memberService.login(memId, memPw);
			session.setAttribute("loginUser", memberService.getMember(memId));
			session.setMaxInactiveInterval(6*60);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} 
//		catch (NotFoundIDException | InvalidPasswordException e) {
//			url = "redirect:";
//		}
		return url;
	}

}