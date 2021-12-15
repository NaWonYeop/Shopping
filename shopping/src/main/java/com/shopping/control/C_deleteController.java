package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.comment.CommentService;
import com.shopping.vo.UserVO;

public class C_deleteController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uId = req.getParameter("user_id");
		int cId = Integer.parseInt(req.getParameter("comment_id"));
		
		HttpSession session = req.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		CommentService service = new CommentService();
		
		if(loginUser.getId().equals(uId)) {
			service.deleteComment(uId, cId);
		}
		
		req.getRequestDispatcher("").forward(req, res);
	}

}
