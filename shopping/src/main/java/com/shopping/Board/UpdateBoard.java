package com.shopping.Board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.control.Controller;
import com.shopping.vo.BoardVO;

public class UpdateBoard implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		BoardVO vo=new BoardVO();
		
		HttpSession session= req.getSession();
		String user=(String) session.getAttribute("UserName");
		
		vo.setBoardId(Integer.parseInt(req.getParameter("bId")));
		vo.setBoardInfo(req.getParameter("bInfo"));
		vo.setBoardName(req.getParameter("bName"));
		vo.setUserName(user);
		
		BoardService service=new BoardService();
		service.update(vo);
		
		//보드 리스트 이동
		req.getRequestDispatcher(null).forward(req, res);
		
	}

}
