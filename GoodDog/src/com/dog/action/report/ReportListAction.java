package com.dog.action.report;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.command.Criteria;
import com.dog.service.report.ReportService;

public class ReportListAction implements Action {
	
	private ReportService reportService;
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/report/reportList";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		String keyword = request.getParameter("keyword");
		String searchType = request.getParameter("searchType");
		
		boolean criFlag = true;
		
		criFlag = criFlag && pageParam !=null
				          && !pageParam.isEmpty()
				          && perPageNumParam !=null
				          && !perPageNumParam.isEmpty();
		
		Criteria cri = new Criteria();
		if(criFlag) {
			try {
				cri.setPage(Integer.parseInt(pageParam));
				cri.setPerPageNum(Integer.parseInt(perPageNumParam));
				cri.setKeyword(keyword);
				cri.setSearchType(searchType);
			} catch(Exception e) {
				response.sendError(response.SC_BAD_REQUEST);
				return null;
			}
		}			
		
		try {
			Map<String, Object> dataMap = reportService.getReportList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/error/500";
		}
		
		return url;
	}

}
