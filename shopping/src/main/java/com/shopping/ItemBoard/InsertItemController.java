package com.shopping.ItemBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shopping.Board.BoardService;
import com.shopping.control.Controller;
import com.shopping.vo.BoardVO;
import com.shopping.vo.ItemBoardVO;

public class InsertItemController implements Controller
{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		
		String savePath = req.getServletContext().getRealPath("image");;
		int maxSize = 1024 * 1024 * 30;
		String encoding="UTF-8";
		MultipartRequest mRequest=new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		ItemBoardVO vo=new ItemBoardVO();
		
				
		vo.setItemImg(mRequest.getFilesystemName("iImg"));
		vo.setItemContent(mRequest.getParameter("iContent"));
		vo.setItemTitle(mRequest.getParameter("iTitle"));
		vo.setItemPrice(Integer.parseInt( mRequest.getParameter("iPrice")));
		
		ItemBoardService service=new ItemBoardService();
		
		
		service.insert(vo);
		
		//아이템 리스트화면이동
		req.getRequestDispatcher("ItemList.do").forward(req, res);
	}

}
