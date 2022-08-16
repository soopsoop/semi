package com.dog.action.happydog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.controller.FileDownloadResolver;
import com.dog.controller.GetUploadPath;
import com.dog.dto.happydog.DogVO;
import com.dog.service.happydog.DogService;

public class DogGetPictureAction implements Action {
	
	private DogService dogService;
	public void setDogService(DogService dogService) {
		this.dogService = dogService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		String dogNo = request.getParameter("dogNo");
		
		try {
			
			DogVO dog = dogService.getDog(dogNo);
			
			String fileName = dog.getDogPic();
			String savedPath = GetUploadPath.getUploadPath("dog.picture.upload");
			
			FileDownloadResolver.sendFile(fileName, savedPath, request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		return url;
	}

}
