package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.comment.CommentService;

public class C_getController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bId = Integer.parseInt(req.getParameter("board_id"));
		
		CommentService service = new CommentService();
		
		Gson gson = new GsonBuilder().create();
		res.getWriter().print(gson.toJson(service.getComment(bId)).toString());
	}

}
