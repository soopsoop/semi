package com.dog.action.happydog;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.command.DogRegistCommand;
import com.dog.controller.HttpRequestParameterAdapter;
import com.dog.dto.happydog.DogVO;
import com.dog.service.happydog.DogService;

public class DogRegistAction implements Action {
	
	private DogService dogService;
	public void setSearchdogService(DogService dogService) {
		this.dogService=dogService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면
		String url="/dog/dogRegist_success";
		
		//입력
		try {
			
			request.setCharacterEncoding("utf-8");
			
			DogRegistCommand command =HttpRequestParameterAdapter.execute(request,
							DogRegistCommand.class );
			DogVO dog = command.toDogVO();
					
			//처리
			dogService.regist(dog);
		
		}catch(Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/dog/dogRegist_fail";
		}
		return url;
	}

}




