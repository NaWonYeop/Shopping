package com.shopping.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.member.JoinController;





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
		list.put("/joinMember.do", new JoinController());
		list.put("/deleteMember.do", null);
		list.put("/updateMember.do", null);
		list.put("/joinMember.do", null);
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
