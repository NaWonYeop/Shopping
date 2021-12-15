package com.shopping.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.ItemBoard.ItemBoardService;
import com.shopping.vo.ItemBoardVO;

public class I_ListController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		ItemBoardService service=new ItemBoardService();
		List<ItemBoardVO> list=service.searchAll();
		
		req.setAttribute("itemList", list);
		
		//아이템리스트화면
		req.getRequestDispatcher("item/itemlist.jsp").forward(req, res);
	}

}
