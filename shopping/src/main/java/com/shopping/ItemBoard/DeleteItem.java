package com.shopping.ItemBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.control.Controller;

public class DeleteItem implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("iId"));
		
		ItemBoardService service=new ItemBoardService();
		service.delete(id);
		
		//아이템 리스트 이동
		req.getRequestDispatcher(null).forward(req, res);
		
	}

}
