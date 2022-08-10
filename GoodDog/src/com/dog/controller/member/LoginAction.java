package com.dog.controller.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.dog.action.Action;
import com.dog.exception.InvalidPasswordException;
import com.dog.exception.NotFoundIDException;
import com.dog.service.member.MemberService;




public class LoginAction implements Action {
   
   private MemberService memberService;
   public void setMemberService(MemberService memberService) {
      this.memberService = memberService;
   }
   
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception{

      String url = "redirect:/index.do";
      
      //입력
      String memId = request.getParameter("id");
      String memPw = request.getParameter("pwd");
      
      //처리
      try {
         memberService.login(memId, memPw);
         
         HttpSession session = request.getSession();
         session.setAttribute("loginUser", memberService.getMember(memId));
         session.setMaxInactiveInterval(6*60);
      } catch (SQLException e) {
         e.printStackTrace();
         throw e;
      }
      catch(InvalidPasswordException | NotFoundIDException e) {
         request.setAttribute("message", e.getMessage());
         	System.out.println(e.getMessage());
        url = "/common/loginFail";
      }
      
      return url;
   }

}