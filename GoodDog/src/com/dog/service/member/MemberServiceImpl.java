package com.dog.service.member;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.command.Criteria;
import com.dog.command.PageMaker;
import com.dog.dao.member.MemberDAO;
import com.dog.vo.member.MemberVO;





public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
		
	@Override
	public Map<String,Object> getMemberList(Criteria cri) throws SQLException {
		
		Map<String,Object> dataMap =null;
		
		//Ã³¸®.......
		List<MemberVO> memberList = memberDAO.selectMemberList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectMemberListCount(cri));
		
		dataMap = new HashMap<String,Object>();
		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public MemberVO getMember(String memId) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(memId);
		return member;
	}

	
	@Override
	public void regist(MemberVO member) throws Exception {
		memberDAO.insertMember(member);
		
	}

	@Override
	public void modify(MemberVO member) throws Exception {
		memberDAO.updateMember(member);		
	}


	@Override
	public void remove(String memId) throws Exception {
		memberDAO.deleteMember(memId);		
	}

//	@Override
//	public void disabled(String id) throws SQLException {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			memberDAO.disabledMember(session, id);
//		} finally {
//			session.close();
//		}
//	}
//
//	@Override
//	public void enabled(String id) throws SQLException {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			memberDAO.enabledMember(session, id);
//		} finally {
//			session.close();
//		}
//		
//	}

}