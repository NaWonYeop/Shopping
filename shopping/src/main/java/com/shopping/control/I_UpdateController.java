package com.shopping.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.ItemBoard.ItemBoardService;
import com.shopping.vo.ItemBoardVO;

public class I_UpdateController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		ItemBoardVO vo=new ItemBoardVO();
		
		vo.setItemId(Integer.parseInt( req.getParameter("iId")) );
		vo.setItemContent(req.getParameter("iContent"));
		vo.setItemTitle(req.getParameter("iTitle"));
		vo.setItemPrice(Integer.parseInt(req.getParameter("iPrice")));
			
		
		ItemBoardService service=new ItemBoardService();
		service.update(vo);
		
		//아이템 리스트 이동
		req.getRequestDispatcher("ItemList.do").forward(req, res);
	}

}
