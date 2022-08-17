package com.dog.command;

import com.dog.vo.volunteer.VolunteerVO;

public class VolRegistCommand {
	private String volTitle;
	private String volDate;
	private String volType;
	private String volContent;
	
	public VolRegistCommand() {
	}
	
	public String getVolTitle() {
		return volTitle;
	}
	public void setVolTitle(String volTitle) {
		this.volTitle = volTitle;
	}
	public String getVolDate() {
		return volDate;
	}
	public void setVolDate(String volDate) {
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
	public void setVolContent(String volContent) {
		this.volContent = volContent;
	}
	

	public VolunteerVO toVolunteerVO() {
		
		VolunteerVO vol = new VolunteerVO();
		vol.setVolTitle(volTitle);
		vol.setVolDate(volDate);
		vol.setVolType(volType);
		vol.setVolContnt(volContent);
//		vol.setMemId(memId);
//		vol.setVolNo(volNo);
		return vol;
		
	}
	

}
