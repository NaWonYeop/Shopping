package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.user.UserService;
import com.shopping.vo.UserVO;

public class U_loginController implements Controller {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");

		System.out.println(id);
		System.out.println(passwd);
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		
		UserService service = new UserService();
		UserVO loginUser = service.loginUser(vo);
		System.out.println(loginUser.getId());
		
		if(id.equals(loginUser.getId())) {
			if(passwd.equals(loginUser.getPasswd())) {
				HttpSession session = req.getSession();
				session.setAttribute("loginUser", loginUser);
				req.getRequestDispatcher("ItemList.do").forward(req, res);
			} else {
				res.sendRedirect("member/login.jsp");
			}
		} else {
			res.sendRedirect("member/login.jsp");
		}
		
	}

}
