package com.dog.action.qnaboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.command.BoardRegistCommand;

import com.dog.controller.HttpRequestParameterAdapter;

import com.dog.vo.qnaboard.QnaVO;

import com.dog.service.qnaboard.QnaService;

public class BoardRegistAction implements Action {
	
	private QnaService qnaService;
	public void setSearcQnaService(QnaService qnaService) {
		this.qnaService=qnaService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면
		String url="/qnaBoard/regist_success";
		
		
		//입력
		try {
			
			request.setCharacterEncoding("utf-8");
			

			/* String memPhone = request.getParameter("memPhone"); */
			
			
			BoardRegistCommand command =HttpRequestParameterAdapter.execute(request, BoardRegistCommand.class );

			
			QnaVO qnaBoard = command.toQnaVO();
			qnaBoard.setQnaTitle(request.getParameter("qnaTitle"));
			qnaBoard.setQnaContent(request.getParameter("qnaContent"));

					System.out.println(url);
			//처리
			qnaService.regist(qnaBoard);
		
		}catch(Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/qnaBoard/regist_fail";
		}
		return url;
	}

}




