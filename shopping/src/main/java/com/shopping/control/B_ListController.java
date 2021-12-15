package com.shopping.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.Board.BoardService;
import com.shopping.vo.BoardVO;


public class BoaradList implements Controller
{

	
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		BoardService service=new BoardService();
		List<BoardVO> list=service.searchAll();
			
		
		req.setAttribute("BoardList", list);
		req.getRequestDispatcher(null).forward(req, res);
		
	}

}
