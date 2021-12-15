package com.shopping.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.vo.BoardVO;

public class BoardDAO extends DAO
{
	//삭제
	public void delete(int bId)
	{
		String sql="delete from SHOP_BOARD where board_id=?";
		connect();
		
		try
		{
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, bId);
			
			int r=psmt.executeUpdate();
			System.out.println(r+"건 삭제");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
	
	//수정
	public void update(BoardVO vo)
	{
		String sql="update SHOP_BOARD set"
				+ " BOARD_TITLE=nvl(?,BOARD_TITLE),"
				+ " BOARD_CONTENT=nvl(?,BOARD_CONTENT),"
				+ " user_id=nvl(?,user_id)"
				+ " where board_id=?";
		connect();
		
		try
		{
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardTitle());
			psmt.setString(2, vo.getBoardContent());
			psmt.setString(3, vo.getUserId());
			psmt.setInt(4, vo.getBoardId());
			
			int r=psmt.executeUpdate();
			System.out.println(r+"건 변경");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		
	}
	//추가
	public void insert(BoardVO vo)
	{
		String idsql="select shop_board_seq.nextval from dual";
		String insql="insert into SHOP_BOARD values(?,?,?,?)";
		
		int seq=-1;
		try
		{
			stmt=conn.createStatement();
			rs=stmt.executeQuery(idsql);
			if(rs.next())
				seq=rs.getInt(1);
			psmt=conn.prepareStatement(insql);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getBoardTitle());
			psmt.setString(3, vo.getBoardContent());
			psmt.setString(4, vo.getUserId());
			
			int r=psmt.executeUpdate();
			System.out.println(r+"건 입력");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//단건조회
	public BoardVO searchone(int boardId) {
		
		String sql="select * from shop_board where board_id=?";
		connect();
		
		try
		{
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, boardId);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardTitle(rs.getString("BOARD_TITLE"));
				vo.setBoardContent(rs.getString("BOARD_CONTENT"));
				vo.setUserId(rs.getString("user_name"));	
				return vo;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return null;
	}
	
	
	//전체조회
	public List<BoardVO> boardList(){
		List<BoardVO> list= new ArrayList<>();
		String sql="select * from shop_board order by 1";
		connect();
		
		try
		{
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardTitle(rs.getString("BOARD_TITLE"));
				vo.setBoardContent(rs.getString("BOARD_CONTENT"));
				vo.setUserId(rs.getString("user_name"));	
				list.add(vo);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return list;
		
	}
}
