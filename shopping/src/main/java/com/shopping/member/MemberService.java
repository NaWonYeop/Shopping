package com.shopping.member;

import com.shopping.dao.MemberDAO;
import com.shopping.vo.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	public void deleteMember(String id) {
		dao.deleteMemver(id);
	}
	
	public MemberVO updateMember(MemberVO vo) {
		return dao.updateMember(vo);
	}
	
	public String getId(String id) {
		return dao.getId(id);
	}
}
