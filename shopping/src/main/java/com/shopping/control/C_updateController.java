package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.comment.CommentService;
import com.shopping.vo.CommentVO;
import com.shopping.vo.UserVO;

public class C_updateController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		
		int cId = Integer.parseInt(req.getParameter("comment_id"));
		String content = req.getParameter("comment_content");
		int bId = Integer.parseInt(req.getParameter("board_id"));
		String uId = req.getParameter("user_id");
		
		CommentVO vo = new CommentVO();
		vo.setcId(cId);
		vo.setContent(content);
		vo.setbId(bId);
		vo.setuId(uId);
		
		HttpSession session = req.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		CommentService service = new CommentService();
		if(loginUser.getId().equals(uId)) {
			service.updateComment(vo);
		}
		req.setAttribute("board_id", bId);
		req.getRequestDispatcher("viewBoard.do").forward(req, res);
		//사용?
	}
}
