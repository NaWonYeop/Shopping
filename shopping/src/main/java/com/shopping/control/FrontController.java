package com.shopping.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.ItemBoard.InsertItemController;
import com.shopping.ItemBoard.ItemListController;

public class FrontController extends HttpServlet {

	HashMap<String, Controller> list = null;

	@Override
	public void init() throws ServletException {
		System.out.println("controller init ");
		list = new HashMap<String, Controller>();

		// 상품페이지
		list.put("/insertItem.do", new InsertItemController());// 등록후 itemlist.jsp
		list.put("/ItemList.do", new ItemListController());
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
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI();// /First/emplist.do

		String context = req.getContextPath();// p20211209/*.do
		int toPos = url.indexOf(".do");
		String path = url.substring(context.length(), toPos + 3);
		System.out.println(path);

		Controller subCont = list.get(path);
		subCont.excute(req, res);
	}
}
