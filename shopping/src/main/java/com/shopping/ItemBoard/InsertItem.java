package com.shopping.ItemBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.Board.BoardService;
import com.shopping.control.Controller;
import com.shopping.vo.BoardVO;
import com.shopping.vo.ItemBoardVO;

public class InsertItem implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		ItemBoardVO vo=new ItemBoardVO();
		
				
		vo.setItemId(Integer.parseInt(req.getParameter("iId")));
		vo.setItemImg(req.getParameter("iImg"));
		vo.setItemInfo(req.getParameter("iInfo"));
		vo.setItemName(req.getParameter("iName"));
		vo.setItemVal(Integer.parseInt(req.getParameter("iVal")));
		
		ItemBoardService service=new ItemBoardService();
		
		
		service.insert(vo);
		
		//아이템 리스트화면이동
		req.getRequestDispatcher(null).forward(req, res);
	}

}
