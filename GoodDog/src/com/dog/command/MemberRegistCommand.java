package com.dog.command;

import java.util.Date;

import com.dog.vo.member.MemberVO;

public class MemberRegistCommand {


	private String memId;  //�븘�씠�뵒
	private String memPw; //�뙣�뒪�썙�뱶
	private String memName="---"; //�씠由�
	private String[] memPhone; //�쟾�솕踰덊샇
	private String memMail;  //�씠硫붿씪


	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemName() {
		return memName;
	}
	public void setName(String memName) {
		this.memName = memName;
	}
	public String[] getMemPhone() {
		return memPhone;
	}
	public void setPhone(String[] memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setEmail(String memMail) {
		this.memMail = memMail;
	}

	
	
	public MemberVO toMemberVO() {
		
		String memPhone = "";
		
//		for (String data : this.memPhone) {
//			memPhone += data;
//		}
		
		// MemberVO setting
		MemberVO member = new MemberVO();
		member.setMemId(memId);
		member.setMemPw(memPw);
//		member.setMemPhone(memPhone);
		member.setMemMail(memMail);
		
		
		member.setMemName(memName);
		member.setMemJoiDate(new Date());
		
		return member;
	}
	
	
}








