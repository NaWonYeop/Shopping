package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.Board.BoardService;
import com.shopping.vo.BoardVO;

public class B_UpdateController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		
		BoardVO vo=new BoardVO();
		
		HttpSession session= req.getSession();
		String uid=(String)session.getAttribute("loginUser");
		
		vo.setBoardId(Integer.parseInt(req.getParameter("board_id")));
		vo.setBoardTitle(req.getParameter("board_title"));
		vo.setBoardContent("board_content");
		vo.setUserId(uid);
		
		BoardService service=new BoardService();
		service.update(vo);
		
		//보드 리스트 이동
		req.getRequestDispatcher("BoardList.do").forward(req, res);
		
	}

}
