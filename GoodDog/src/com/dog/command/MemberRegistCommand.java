package com.dog.command;

import java.util.Date;

import com.dog.action.member.SHA256;
import com.dog.dto.member.MemberVO;



public class MemberRegistCommand {


	private String memId;  //�븘�씠�뵒
	private String memPw; //�뙣�뒪�썙�뱶
	private String memName; //�씠由�
	private String[] memPhone; //�쟾�솕踰덊샇
	private String memMail;  //�씠硫붿씪
	private String memGender;
	private String memRegNo;
	private String memAddr;


	
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getMemRegNo() {
		return memRegNo;
	}
	public void setMemRegNo(String memRegNo) {
		this.memRegNo = memRegNo;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String[] getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String[] memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemEmail(String memMail) {
		this.memMail = memMail;
	}

	
	
	public MemberVO toMemberVO() {
		
		String memPhone = "";
		
		for (String data : this.memPhone) {
			memPhone += data;
		}
		
		String password = SHA256.encodeSha256(memPw);
		
		// MemberVO setting
		MemberVO member = new MemberVO();
		member.setMemId(memId);
		member.setMemPw(password);
		member.setMemPhone(memPhone);
		member.setMemMail(memMail);
		member.setMemAddr(memAddr);
		member.setMemGender(memGender);
		member.setMemRegNo(memRegNo);
		member.setMemName(memName);
		member.setMemJoiDate(new Date());
		
		return member;
	}
	
	
}








