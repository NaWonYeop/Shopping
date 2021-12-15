package com.shopping.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		list.put("/joinMember.do", new U_ioinController()); // ->login.jsp
		list.put("/deleteMember.do", new U_deleteController()); // ->index.jsp
		list.put("/updateMember.do", new U_updateController()); // ->login.jsp
		list.put("/getId.do", new U_getController()); // ->join.jsp
		
		// 댓글
		list.put("/insertComment.do", new C_inserController());
		list.put("/deleteComment.do", new C_deleteController());
		list.put("/updateComment.do", new C_updateController());
		list.put("/getComment.do", new C_getController());
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
