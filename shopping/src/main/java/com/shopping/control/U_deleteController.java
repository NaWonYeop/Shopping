package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.member.MemberService;

public class U_deleteController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		MemberService service = new MemberService();
		service.deleteMember(id);
		
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
	
}
