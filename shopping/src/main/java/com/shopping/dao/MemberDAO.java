package com.shopping.dao;

import java.sql.SQLException;

import com.shopping.vo.UserVO;

public class MemberDAO extends DAO {
	// login
	public UserVO login(UserVO vo) {
		String sql = "select * from shop_user where user_id = ? and passwd = ?";
		connect();
		UserVO loginUser = new UserVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			rs = psmt.executeQuery();
			if(rs.next()) {
				loginUser.setId(rs.getString("user_id"));
				loginUser.setPasswd(rs.getString("passwd"));
				loginUser.setName(rs.getString("user_name"));
				return loginUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return loginUser;
	}

	// id중복체크
	public String getId(String id) {
		String userId = "";
		String sql = "select * from shop_user where user_id = " + id;
		connect();
		try {
			conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				userId = rs.getString("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return userId;
	}

	// 수정
	public UserVO updateMember(UserVO vo) {
		String sql = "update shop_user set passwd = NVL(?, passwd), user_name = NVL(?, user_name) where user_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 삭제
	public void deleteMemver(String id) {
		String sql = "delete shop_user where user_id = ?";
		connect();

		try {
			conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 가입
	public void insertMember(UserVO vo) {
		String sql = "insert into shop_user values(?, ?, ?)";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
