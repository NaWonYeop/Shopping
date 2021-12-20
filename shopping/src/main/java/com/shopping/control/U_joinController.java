package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.user.UserService;
import com.shopping.vo.UserVO;

public class U_joinController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		
		UserService service = new UserService();
		service.insertMember(vo);
		
		req.getRequestDispatcher("member/login.jsp").forward(req, res);
	}

}
