package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.Board.BoardService;
import com.shopping.vo.BoardVO;
import com.shopping.vo.UserVO;

public class B_InsertController implements Controller
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
		UserVO us=(UserVO)session.getAttribute("loginUser");
		String uid=us.getId();
	
		
		vo.setBoardTitle(req.getParameter("board_title"));
		vo.setBoardContent(req.getParameter("board_content"));
		vo.setUserId(uid);

		
		BoardService service=new BoardService();

		service.insert(vo);
		
		//보드 리스트화면이동
		req.getRequestDispatcher("BoardList.do").forward(req, res);
		
	}

}
