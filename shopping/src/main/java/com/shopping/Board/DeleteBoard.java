package com.shopping.Board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.control.Controller;

public class DeleteBoard implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		int bId=Integer.parseInt(req.getParameter("bId")); 
		BoardService service=new BoardService();
		service.delete(bId);
		
		//보드 리스트화면이동
		req.getRequestDispatcher(null).forward(req, res);
	}

}
