package com.dog.action.happydog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.controller.MakeFileName;
import com.dog.dto.happydog.DogVO;
import com.dog.service.happydog.DogService;

public class DogModifyFormAction implements Action {

	private DogService dogService;
	public void setSearchdogService(DogService dogService) {
		this.dogService = dogService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/dog/dogModify";
		
		try {
			String dogNo = request.getParameter("dogNo");
			DogVO dog = dogService.getDog(dogNo);
			
			String originalFileName = MakeFileName.parseFileNameFromUUID(dog.getDogPic(),"\\$\\$");
			
			dog.setDogPic(originalFileName);
			
			request.setAttribute("dog", dog);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}