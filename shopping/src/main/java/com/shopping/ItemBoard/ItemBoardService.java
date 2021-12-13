package com.shopping.ItemBoard;

import java.util.List;

import com.shopping.dao.ItemBoardDAO;
import com.shopping.vo.ItemBoardVO;

public class ItemBoardService
{
	ItemBoardDAO dao=new ItemBoardDAO();
	
	public List<ItemBoardVO> searchAll()
	{
		return dao.boardList();
	}
	public ItemBoardVO searchOne(int bId)
	{
		return dao.searchone(bId);
	}
	public void insert(ItemBoardVO vo)
	{
		dao.insert(vo);
	}
	public void update(ItemBoardVO vo)
	{
		dao.update(vo);
	}
	public void delete(int bId)
	{
		dao.delete(bId);
	}
}
