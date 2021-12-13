package com.shopping.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.control.Controller;
import com.shopping.vo.MemberVO;

public class GetIdController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		MemberService service = new MemberService();
		String getId = service.getId(id);
		req.setAttribute("id", getId);
		
		req.getRequestDispatcher("/join.jsp").forward(req, res);
	}

}
