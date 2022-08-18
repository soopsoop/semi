package com.dog.command;

import java.util.Date;

import com.dog.vo.member.MemberVO;
import com.dog.vo.qnaboard.QnaVO;

public class BoardRegistCommand {


	private String qnaTitle;
	private String qnaContent;


	public String getQnaTitle() {
		return qnaTitle;
	}


	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}


	public String getQnaContent() {
		return qnaContent;
	}


	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}


	public QnaVO toQnaVO() {
		
		// MemberVO setting
		QnaVO qnaBoard = new QnaVO();
	
		qnaBoard.setQnaTitle(qnaTitle);
		qnaBoard.setQnaContent(qnaContent);

		
//		member.setMemName(memName);
//		member.setMemJoiDate(new Date());
		
		return qnaBoard;
	}
	
	
}








