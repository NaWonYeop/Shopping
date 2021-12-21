package com.shopping.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.vo.CommentVO;

public class CommentDAO extends DAO {
	
	// 댓글 출력
	public List<CommentVO> getComments(int bId){
		List<CommentVO> list = new ArrayList<>();
		String sql = "select * from shop_comment where board_id = " + bId + "order by 1";
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setcId(rs.getInt("comment_id"));
				vo.setContent(rs.getString("comment_content"));
				vo.setbId(rs.getInt("board_id"));
				vo.setuId(rs.getString("user_id"));
				
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	// 댓글 수정
	public CommentVO updateComment(CommentVO vo) {
		String sql = "update shop_comment set comment_content = ? where comment_id =? and user_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getcId());
			psmt.setString(3, vo.getuId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	
	// 댓글 삭제
	public void deleteComment(String uId, int cId) {
		String sql = "delete shop_comment where comment_id = ? and user_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cId);
			psmt.setString(2, uId);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 댓글 입력
	public void insertComment(CommentVO vo) {
		String sql = "insert into shop_comment(comment_id, comment_content, board_id, user_id)"
				+ "values (shop_comment_seq.nextval, ?, ?, ?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getbId());
			psmt.setString(3, vo.getuId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
