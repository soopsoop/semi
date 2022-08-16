package com.dog.action.happydog;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.dto.happydog.DogVO;
import com.dog.service.happydog.DogService;

public class DogDetailAction implements Action {
	
	private DogService dogService;
	public void setDogService(DogService dogService) {
		this.dogService=dogService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/dog/dogDetail";
		
		String dogNo=request.getParameter("dogNo");
		
		try {
			DogVO dog = dogService.getDog(dogNo);
			
			
			request.setAttribute("dog", dog);
			
		} catch (Exception e) {
			e.printStackTrace();
			url = "/dog/dogDetail_fail";
		}
		return url;
	}

}
