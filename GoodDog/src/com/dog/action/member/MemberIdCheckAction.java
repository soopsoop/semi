package com.dog.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.dto.member.MemberVO;
import com.dog.service.member.MemberService;

public class MemberIdCheckAction implements Action {

	
	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService=memberService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		String memId=request.getParameter("memId");
		
		String resultStr = "";
		
		try {
			MemberVO member = memberService.getMember(memId);
			if(member!=null) {
				resultStr="DUPLICATED";
			}		
			
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(resultStr);
			out.close();
			
		}catch(Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}







