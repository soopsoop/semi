package com.dog.action.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.service.member.MemberService;

public class FindIdAction implements Action {

	   private MemberService memberService;
	   public void setMemberService(MemberService memberService) {
	      this.memberService = memberService;
	   }
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/loginForm.do";
		
		
		  String memMail = request.getParameter("memMail");
	      String memName = request.getParameter("memName");
	  try {
	      memberService.findMemberById(memMail, memName);
	      
	      
      } catch (SQLException e) {
          e.printStackTrace();
          throw e;
       }
		return url;
	      
	      
	}

}
