package com.shopping.comment;

import java.util.List;

import com.shopping.dao.CommentDAO;
import com.shopping.vo.CommentVO;

public class CommentService {
	CommentDAO dao = new CommentDAO();

	public void insertComment(CommentVO vo) {
		dao.insertComment(vo);
	}

	public void deleteComment(String uId, int cId) {
		dao.deleteComment(uId, cId);
	}

	public CommentVO updateComment(CommentVO vo) {
		return dao.updateComment(vo);
	}

	public List<CommentVO> getComment(int bId) {
		return dao.getComments(bId);
	}
}
