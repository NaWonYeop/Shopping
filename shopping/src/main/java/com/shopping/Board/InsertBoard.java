package com.shopping.Board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.control.Controller;
import com.shopping.vo.BoardVO;

public class InsertBoard implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		BoardVO vo=new BoardVO();
		
		HttpSession session= req.getSession();
		String uname=(String) session.getAttribute("UserName");
		String uid=(String)session.getAttribute("UserId");
				
		vo.setBoardId(Integer.parseInt(req.getParameter("bId")));
		vo.setBoardInfo(req.getParameter("bInfo"));
		vo.setBoardName(req.getParameter("bName"));
		vo.setUserId(uid);
		vo.setUserName(uname);
		
		BoardService service=new BoardService();
		
		
		service.insert(vo);
		
		//보드 리스트화면이동
		req.getRequestDispatcher(null).forward(req, res);
		
	}

}
