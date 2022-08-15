package com.dog.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.vo.member.MemberVO;
import com.dog.service.member.MemberService;

public class MemberDetailAction implements Action {

	private MemberService memberService;

	public void setSearchMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/detail";

		String memId = request.getParameter("memId");
		
		
		  try { MemberVO member = memberService.getMember(memId);
		  
		  request.setAttribute("member", member);
		  
		  }catch(Exception e) { e.printStackTrace(); // ........
		  url = "/member/detail_fail";
		  //response.sendError(response.SC_INTERNAL_SERVER_ERROR); }
		 
		  }
		  
		return url;
	
	}
}