package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.Board.BoardService;
import com.shopping.vo.BoardVO;

public class B_InsertController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		BoardVO vo=new BoardVO();
		
		HttpSession session= req.getSession();
		String uid=(String)session.getAttribute("loginUser");
				
		vo.setBoardId(Integer.parseInt(req.getParameter("board_id")));
		vo.setBoardTitle(req.getParameter("board_title"));
		vo.setBoardContent("boart_content");
		vo.setUserId(uid);

		
		BoardService service=new BoardService();
		
		
		service.insert(vo);
		
		//보드 리스트화면이동
		req.getRequestDispatcher("BoardList.do").forward(req, res);
		
	}

}
