package com.dog.command;

import java.util.Date;

import com.dog.dto.report.ReportVO;

public class ReportRegistCommand {
	private String reportNo;
	private String reportTitle;
	private String reportType;
	private String reportBreed;
	private String reportGender;
	private String reportPlace;
	private String reportFeature;
	private String reportPic;
	private String foundDate;
	private Date reportDate;
	private String memId; //?????? 어떻게 해야 session에 있는 id를 가져오냐?

//	public String getReportNo() {
//		return reportNo;
//	}
//
//	public void setReportNo(String reportNo) {
//		this.reportNo = reportNo;
//	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportBreed() {
		return reportBreed;
	}

	public void setReportBreed(String reportBreed) {
		this.reportBreed = reportBreed;
	}

	public String getReportGender() {
		return reportGender;
	}

	public void setReportGender(String reportGender) {
		this.reportGender = reportGender;
	}

	public String getReportPlace() {
		return reportPlace;
	}

	public void setReportPlace(String reportPlace) {
		this.reportPlace = reportPlace;
	}

	public String getReportFeature() {
		return reportFeature;
	}

	public void setReportFeature(String reportFeature) {
		this.reportFeature = reportFeature;
	}

	public String getReportPic() {
		return reportPic;
	}

	public void setReportPic(String reportPic) {
		this.reportPic = reportPic;
	}

	public String getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(String foundDate) {
		this.foundDate = foundDate;
	}

//	public Date getReportDate() {
//		return reportDate;
//	}
//
//	public void setReportDate(Date reportDate) {
//		this.reportDate = reportDate;
//	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public ReportVO toReportVO() {

		ReportVO report = new ReportVO();
//		report.setReportNo(reportNo);
		report.setReportTitle(reportTitle);
		report.setReportType(reportType);
		report.setReportBreed(reportBreed);
		report.setReportGender(reportGender);
		report.setReportPlace(reportPlace);
		report.setReportFeature(reportFeature);
		report.setReportPic(reportPic);
		report.setFoundDate(foundDate);
//		report.setReportDate(reportDate);
		report.setMemId(memId);
		
		return report;

	}

}
