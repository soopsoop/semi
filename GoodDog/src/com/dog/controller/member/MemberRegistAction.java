package com.dog.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.command.MemberRegistCommand;
import com.dog.controller.HttpRequestParameterAdapter;
import com.dog.vo.member.MemberVO;
import com.dog.service.member.MemberService;

public class MemberRegistAction implements Action {
	
	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면
		String url="/member/regist_success";
		
		
		//입력
		try {
			
			request.setCharacterEncoding("utf-8");
			

			String memPhone = request.getParameter("memPhone");
			
			
			MemberRegistCommand command =HttpRequestParameterAdapter.execute(request, MemberRegistCommand.class );

			
			MemberVO member = command.toMemberVO();
			member.setMemPw(request.getParameter("memPw"));
			member.setMemGender(request.getParameter("memGender"));
			member.setMemRegNo(request.getParameter("memRegNo"));
			member.setMemMail(request.getParameter("memMail"));
			member.setMemPhone(request.getParameter("memPhone"));
			member.setMemAddr(request.getParameter("memAddr"));
					System.out.println(url);
			//처리
			memberService.regist(member);
		
		}catch(Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/member/regist_fail";
		}
		return url;
	}

}




