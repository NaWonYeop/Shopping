package com.shopping.itemBoard;

import java.util.List;

import com.shopping.dao.ItemBoardDAO;
import com.shopping.vo.ItemBoardVO;


public class ItemBoardService
{
	ItemBoardDAO dao=new ItemBoardDAO();
 
	public List<ItemBoardVO> searchAll()
	{
		return dao.memberList();
	}
}
