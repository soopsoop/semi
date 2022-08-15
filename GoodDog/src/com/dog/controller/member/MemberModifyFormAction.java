package com.dog.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.controller.MakeFileName;
import com.dog.vo.member.MemberVO;
import com.dog.service.member.MemberService;

public class MemberModifyFormAction implements Action {

	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/modify";
		
		try {
			String memId = request.getParameter("memId");
			MemberVO member = memberService.getMember(memId);
			
			
			/*
			 * String originalFileName =
			 * MakeFileName.parseFileNameFromUUID(member.getPicture(),"\\$\\$");
			 * 
			 * member.setPicture(originalFileName);
			 */
			
			request.setAttribute("member", member);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}