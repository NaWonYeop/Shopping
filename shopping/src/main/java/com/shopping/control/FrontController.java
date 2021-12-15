package com.shopping.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.ItemBoard.InsertItemController;
import com.shopping.ItemBoard.ItemListController;
import com.shopping.member.DeleteController;
import com.shopping.member.GetIdController;
import com.shopping.member.JoinController;
import com.shopping.member.UpdateController;

public class FrontController extends HttpServlet
{
	
	HashMap<String,Controller> list=null;
	@Override
	public void init() throws ServletException
	{
		System.out.println("controller init ");
		list=new HashMap<String,Controller>();
	
		//상품페이지
		list.put("/insertItem.do",new InsertItemController());//등록후 itemlist.jsp
		list.put("/ItemList.do", new ItemListController());
		// 회원
		list.put("/joinMember.do", new JoinController()); // ->login.jsp
		list.put("/deleteMember.do", new DeleteController()); // ->index.jsp
		list.put("/updateMember.do", new UpdateController()); // ->login.jsp
		list.put("/getId.do", new GetIdController()); // ->join.jsp
		
		// 댓글
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String url=req.getRequestURI();// /First/emplist.do
		
		String context=req.getContextPath();//p20211209/*.do
		int toPos=url.indexOf(".do");
		String path=url.substring(context.length(),toPos+3);
		System.out.println(path);
		
		Controller subCont=list.get(path);
		subCont.excute(req, res);
	}
}
