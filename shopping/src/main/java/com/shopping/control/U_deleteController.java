package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.user.UserService;

public class U_deleteController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		UserService service = new UserService();
		service.deleteMember(id);
		
		res.sendRedirect("index.jsp");
	}
	
}
