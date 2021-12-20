package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.ItemBoard.ItemBoardService;
import com.shopping.vo.ItemBoardVO;

public class I_ItemController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		
		int iId=Integer.parseInt(req.getParameter("iId")) ;
		
		
		
		ItemBoardService service=new ItemBoardService();
		ItemBoardVO vo=service.searchOne(iId);
		
		req.setAttribute("SingleItem", vo);
		
		
	
		
		//싱글보드 이동
		req.getRequestDispatcher("item/item.jsp").forward(req, res);
	}

}
