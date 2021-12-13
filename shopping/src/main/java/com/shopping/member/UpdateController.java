package com.shopping.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.control.Controller;
import com.shopping.vo.MemberVO;

public class UpdateController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPasswd(passwd);
		
		MemberService service = new MemberService();
		service.updateMember(vo);
		
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}

}
