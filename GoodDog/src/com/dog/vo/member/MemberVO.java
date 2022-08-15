package com.dog.vo.member;


import java.util.Date;

public class MemberVO {
	private String memId;			// ���̵�
	private String memPw;			// �н�����
	private String memName;		// �̸�
	private String memGender;
	private String memRegNo;
	private String memMail;
	private String memPhone;		// ��ȭ��ȣ
	private String memAddr;		// �ּ�
	private Date memJoinDate;		// �����
	
	public MemberVO() {}
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
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public Date getMemJoinDate() {
		return memJoinDate;
	}
	public void setMemJoiDate(Date memJoinDate) {
		this.memJoinDate = memJoinDate;
	}

	
	
}