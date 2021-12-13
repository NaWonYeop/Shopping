package com.shopping.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		//로그인
		//list.put("/login.do", new LoginController());
		
		
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

		
		Controller subCont=list.get(path);
		subCont.excute(req, res);
	}
}
