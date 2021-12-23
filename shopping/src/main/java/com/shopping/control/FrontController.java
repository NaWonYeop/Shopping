package com.shopping.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {

	HashMap<String, Controller> list = null;

	@Override
	public void init() throws ServletException {
		System.out.println("controller init ");
		list = new HashMap<String, Controller>();
		//자유게시판
		list.put("/insertBoard.do", new B_InsertController());// 등록후 boardlist.do
		list.put("/BoardList.do", new B_ListController());// ->boardlist.jsp
		list.put("/updateBoard.do", new B_UpdateController());// ->업데이트후 boardlist.do
		list.put("/deleteBoard.do", new B_DeleteController());// ->딜리트후 boardlist.do
		list.put("/viewBoard.do", new B_BoardController());// ->board.jsp
		list.put("/updateBoardForm.do", new B_UpFormController());
		// 상품페이지
		list.put("/insertItem.do", new I_InsertController());// 등록후 itemlist.do
		list.put("/ItemList.do", new I_ListController());// ->itemlist.jsp
		list.put("/updateItem.do", new I_UpdateController());// ->업데이트후 itemlist.do
		list.put("/deleteItem.do", new I_DeleteController());// ->딜리트후 itemlist.do
		list.put("/viewItem.do", new I_ItemController());// ->item.jsp
		list.put("/updateItemForm.do", new I_UpFormController());//->updateItem.jsp
		
		// 회원
		list.put("/joinMember.do", new U_joinController()); // ->login.jsp
		list.put("/deleteMember.do", new U_deleteController()); // ->index.jsp
		list.put("/updateMember.do", new U_updateController()); // ->login.jsp
		list.put("/getId.do", new U_getController()); // ->join.jsp
		list.put("/login.do", new U_loginController());

		// 댓글
		list.put("/insertComment.do", new C_inserController());
		list.put("/deleteComment.do", new C_deleteController());
		list.put("/updateComment.do", new C_updateController());
		list.put("/getComment.do", new C_getController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI();// /First/emplist.do
		System.out.println(url);

		String context = req.getContextPath();// p20211209/*.do
		int toPos = url.indexOf(".do");
		String path = url.substring(context.length());
		System.out.println(path);
		
		Controller subCont = list.get(path);
		subCont.excute(req, res);
	}
}
