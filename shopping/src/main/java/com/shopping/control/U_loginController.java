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
		
		if(id.equals(loginUser.getId())) {
			if(passwd.equals(loginUser.getPasswd())) {
				HttpSession session = req.getSession();
				session.setAttribute("loginUser", loginUser);
				req.getRequestDispatcher("ItemList.do").forward(req, res);
			} else {
				req.setAttribute("error", "아이디 혹은 비밀번호가 틀립니다.");
				req.getRequestDispatcher("member/login.jsp").forward(req, res);
			}
		} else {
			req.setAttribute("error", "존재하지 않는 아이디입니다.");
			req.getRequestDispatcher("member/login.jsp").forward(req, res);
		}
		
	}

}
