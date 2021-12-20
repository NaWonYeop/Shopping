package com.shopping.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.Board.BoardService;
import com.shopping.vo.BoardVO;


public class B_ListController implements Controller
{

	
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		BoardService service=new BoardService();
		List<BoardVO> list=service.searchAll();
			
		
		req.setAttribute("BoardList", list);
		req.getRequestDispatcher("board/boardlist.jsp").forward(req, res);
		
	}

}
