package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.comment.CommentService;
import com.shopping.vo.CommentVO;

public class C_inserController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int cId = Integer.parseInt(req.getParameter("comment_id"));
		String content = req.getParameter("comment_content");
		int bId = Integer.parseInt(req.getParameter("board_id"));
		String uId = req.getParameter("user_id");
		
		CommentService service = new CommentService();
		CommentVO vo = new CommentVO();
		vo.setcId(cId);
		vo.setContent(content);
		vo.setbId(bId);
		vo.setuId(uId);
		
		service.insertComment(vo);
		
		req.getRequestDispatcher("").forward(req, res);
		
	}

}
