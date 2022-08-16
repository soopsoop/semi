package com.dog.action.happydog;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.dto.happydog.DogVO;
import com.dog.service.happydog.DogService;


public class DogIdCheckAction implements Action {

	
	private DogService dogService;
	public void setSearchDogService(DogService dogService) {
		this.dogService=dogService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		String dogNo=request.getParameter("dogNo");
		
		String resultStr = "";
		
		try {
			DogVO dog = dogService.getDog(dogNo);
			if(dog!=null) {
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







