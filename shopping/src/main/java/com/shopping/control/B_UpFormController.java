package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.Board.BoardService;
import com.shopping.ItemBoard.ItemBoardService;
import com.shopping.vo.BoardVO;
import com.shopping.vo.ItemBoardVO;

public class B_UpFormController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		int iId=Integer.parseInt(req.getParameter("bId")) ;
		
		
		
		BoardService service=new BoardService();
		BoardVO vo= service.searchOne(iId);
		
		req.setAttribute("SingleBoard", vo);
		
		System.out.println(vo.getBoardContent());
		System.out.println(vo.getBoardId());
		System.out.println(vo.getBoardTitle());
		
		//싱글보드 이동
		req.getRequestDispatcher("board/updateBoard.jsp").forward(req, res);
	}

}
