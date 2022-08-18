package com.dog.dto.adoptwant;

import java.util.Date;

public class AdoptWantVO {

	private String wantNo;
	private String wantTitle;
	private String memId;
	private String wantContent;
	private Date wantDate;

	public String getWantNo() {
		return wantNo;
	}

	public void setWantNo(String wantNo) {
		this.wantNo = wantNo;
	}

	public String getWantTitle() {
		return wantTitle;
	}

	public void setWantTitle(String wantTitle) {
		this.wantTitle = wantTitle;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getWantContent() {
		return wantContent;
	}

	public void setWantContent(String wantContent) {
		this.wantContent = wantContent;
	}

	public Date getWantDate() {
		return wantDate;
	}

	public void setWantDate(Date wantDate) {
		this.wantDate = wantDate;
	}

}
