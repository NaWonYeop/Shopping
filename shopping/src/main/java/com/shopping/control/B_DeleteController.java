package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.Board.BoardService;

public class B_DeleteController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		int bId=Integer.parseInt(req.getParameter("board_id")); 
		BoardService service=new BoardService();
		service.delete(bId);
		
		//보드 리스트화면이동
		req.getRequestDispatcher("BoardList.do").forward(req, res);
	}

}
