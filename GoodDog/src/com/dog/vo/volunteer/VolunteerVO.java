package com.dog.vo.volunteer;

import java.util.Date;

public class VolunteerVO {

	private String volTitle;
	private Date volDate;
	private String volType;
	private String volContent;
	private String memId;
	private String volNo; // 봉사지원자넘버

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getVolTitle() {
		return volTitle;
	}

	public void setVolTitle(String volTitle) {
		this.volTitle = volTitle;
	}

	public Date getVolDate() {
		return volDate;
	}

	public void setVolDate(Date volDate) {
		this.volDate = volDate;
	}

	public String getVolType() {
		return volType;
	}

	public void setVolType(String volType) {
		this.volType = volType;
	}

	public String getVolContent() {
		return volContent;
	}

	public void setVolContnt(String volContent) {
		this.volContent = volContent;
	}

	public String getVolNo() {
		return volNo;
	}

	public void setVolNo(String volNo) {
		this.volNo = volNo;
	}

}
