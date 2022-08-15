package com.dog.controller.member;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.action.Action;
import com.dog.controller.FileUploadResolver;
import com.dog.controller.GetUploadPath;
import com.dog.controller.MultipartHttpServletRequestParser;
import com.dog.vo.member.MemberVO;
import com.dog.exception.NotMultipartFormDataException;
import com.dog.service.member.MemberService;

public class MemberModifyAction implements Action {

	private MemberService memberService;

	public void setSearchMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500KB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1; // 1MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2MB

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/member/modify_success";
		
		MultipartHttpServletRequestParser multiReq = null;
		try {
		 multiReq = new MultipartHttpServletRequestParser(request,MEMORY_THRESHOLD, 
				 												  MAX_FILE_SIZE, 
				 												  MAX_REQUEST_SIZE);
		}catch (NotMultipartFormDataException e) {
			response.sendError(response.SC_BAD_REQUEST);
			return null;
		}
		
		String memId = multiReq.getParameter("memId");
		String memPw = multiReq.getParameter("memPw");
		String memMail = multiReq.getParameter("memMail");
//		String authority = multiReq.getParameter("authority");
		String memName = multiReq.getParameter("memName");
		String memPhone = multiReq.getParameter("memPhone");

		MemberVO member = new MemberVO();
		member.setMemId(memId);
		member.setMemPw(memPw);
		member.setMemPhone(memPhone);
		member.setMemMail(memMail);
//		member.setAuthority(authority);
		member.setMemName(memName);
		

		MemberVO oldMember = memberService.getMember(memId);
		
		/*
		 * String uploadPicture = multiReq.getParameter("uploadPicture");
		 * if(uploadPicture!=null && !uploadPicture.isEmpty()) {
		 * 
		 * 
		 * String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
		 * File file = new File(uploadPath);
		 * 
		 * List<File> fileList =
		 * FileUploadResolver.fileUpload(multiReq.getFileItems("picture"),uploadPath);
		 * File saveFile = fileList.get(0);
		 * 
		 * member.setPicture(saveFile.getName());
		 * 
		 * 
		 * String oldPicture = oldMember.getPicture(); File deleteFile = new
		 * File(uploadPath,oldPicture); if(deleteFile.exists()) { deleteFile.delete(); }
		 * 
		 * }else { member.setPicture(oldMember.getPicture()); }
		 */
		

		
		memberService.modify(member);
		
		
		request.setAttribute("member",  memberService.getMember(member.getMemId()));
		
		
		request.setAttribute("parentReload",false);

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser!=null && member.getMemId().equals(loginUser.getMemId())) {
			request.setAttribute("parentReload",true);
			session.setAttribute("loginUser", memberService.getMember(member.getMemId()));
		}
				
		return url;
	}

}







