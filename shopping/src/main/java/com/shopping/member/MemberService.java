package com.shopping.member;

import com.shopping.dao.MemberDAO;
import com.shopping.vo.UserVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public void insertMember(UserVO vo) {
		dao.insertMember(vo);
	}
	
	public void deleteMember(String id) {
		dao.deleteMemver(id);
	}
	
	public UserVO updateMember(UserVO vo) {
		return dao.updateMember(vo);
	}
	
	public String getId(String id) {
		return dao.getId(id);
	}
}
