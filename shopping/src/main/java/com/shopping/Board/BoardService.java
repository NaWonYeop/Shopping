package com.shopping.Board;

import java.util.List;

import com.shopping.dao.BoardDAO;
import com.shopping.vo.BoardVO;


public class BoardService
{
	BoardDAO dao=new BoardDAO();
 
	public List<BoardVO> searchAll()
	{
		return dao.boardList();
	}
	public BoardVO searchOne(int id)
	{
		return dao.searchone(id);
	}
	public void insert(BoardVO vo)
	{
		dao.insert(vo);
	}
	public void update(BoardVO vo)
	{
		dao.update(vo);
	}
	public void delete(int bId)
	{
		dao.delete(bId);
	}
}
