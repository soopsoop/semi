package com.dog.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;



public class DispatcherServlet extends HttpServlet {
	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("url.properties");

		try {
			if (path != null) {
				handlerMapper = new HandlerMapper(path);
			} else {
				handlerMapper = new HandlerMapper();
			}

			System.out.println("[DispatcherServlet] handlerMapper 가 준비되었습니다.");
		} catch (Exception e) {
			System.out.println("[DispatcherServlet] handlerMapper 가 준비되었습니다.");
			e.printStackTrace();
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �궗�슜�옄 URI 寃�異�
		String command = request.getRequestURI(); // contextPath �룷�븿.
		if (command.indexOf(request.getContextPath()) == 0) { // contextPath �궘�젣
			command = command.substring(request.getContextPath().length());
		}
		
		//commandHandler �떎�뻾 (HandlerMapper �쓽猶�  action �븷�떦)
		Action action = null;
		String view = null;
		
		if (handlerMapper != null){
			action = handlerMapper.getAction(command);
			if(action!=null) { //�삱諛붾Ⅸ �슂泥�
				
				try {
					view = action.process(request, response);
					if (view == null) {
						return;
					}
					
					request.setAttribute("viewName", view);
					
					JSPViewResolver.view(request, response);
					
				} catch (Exception e) {					
					e.printStackTrace();
					//Exception 泥섎━
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);					
				}
			}else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}	
		}else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}

}












