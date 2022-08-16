package com.dog.action.happydog;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.action.Action;
import com.dog.controller.GetUploadPath;
import com.dog.dto.happydog.DogVO;
import com.dog.service.happydog.DogService;

public class DogRemoveAction implements Action {
	
	private DogService dogService;
	public void setSearchdogService(DogService dogService) {
		this.dogService=dogService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/dog/dogRemove_success";
		
		String dogNo = request.getParameter("dogNo");
		
		DogVO dog = dogService.getDog(dogNo);
		// 사진 이미지 삭제
		String picture = dog.getDogPic();
		String savedPath = GetUploadPath.getUploadPath("dog.picture.upload");
		
		try {
			File deletePictureFile = new File(savedPath, picture);
			if(deletePictureFile.exists()) deletePictureFile.delete();
		} catch (Exception e) {
			System.out.println("사진이 없습니다.");
		}
		
		// DB 삭제
		dogService.remove(dogNo);
		
		// loginUser 확인
		HttpSession session = request.getSession();
		DogVO loginUser = (DogVO) session.getAttribute("loginUser");
		if(loginUser != null && dog.getDogNo().equals(loginUser.getDogNo())) {
			session.invalidate();
		}
		
		request.setAttribute("dog", dog);
		
		return url;
	}

}
