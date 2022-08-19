package com.dog.action.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.command.ReportRegistCommand;
import com.dog.controller.HttpRequestParameterAdapter;
import com.dog.service.report.ReportService;
import com.dog.dto.report.ReportVO;

public class ReportRegistAction implements Action {
	
	private ReportService reportService;
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/report/reportRegist_success";
		
		try {
			request.setCharacterEncoding("utf-8");
			
			ReportRegistCommand command = 
					HttpRequestParameterAdapter.execute(request, ReportRegistCommand.class);
			
			ReportVO report = command.toReportVO();
			
			reportService.insertReport(report);
			
		} catch (Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/report/reportRegist_fail";
		}
		
		return url;
	}

}
