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
		String sql="delete from board where board_id=?";
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
		String sql="update board set"
				+ " board_name=nvl(?,board_name),"
				+ " board_info=nvl(?,board_info),"
				+ " user_name=nvl(?,user_name),"
				+ " user_id=nvl(?,user_id)"
				+ " where board_id=?";
		connect();
		
		try
		{
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardName());
			psmt.setString(2, vo.getBoardInfo());
			psmt.setString(3, vo.getUserName());
			psmt.setString(4, vo.getUserId());
			psmt.setInt(5, vo.getBoardId());
			
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
		String idsql="select board_seq.nextval from dual";
		String insql="insert into board values(?,?,?,?,?)";
		
		int seq=-1;
		try
		{
			stmt=conn.createStatement();
			rs=stmt.executeQuery(idsql);
			if(rs.next())
				seq=rs.getInt(1);
			psmt=conn.prepareStatement(insql);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getBoardName());
			psmt.setString(3, vo.getBoardInfo());
			psmt.setString(4, vo.getUserName());
			psmt.setString(5, vo.getUserId());
			
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
		
		String sql="select * from board where board_id=?";
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
				vo.setBoardName(rs.getString("board_name"));
				vo.setBoardInfo(rs.getString("board_info"));
				vo.setUserId(rs.getString("user_name"));
				vo.setUserName(rs.getString("user_id"));
				
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
		String sql="select * from board order by 1";
		connect();
		
		try
		{
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardName(rs.getString("board_name"));
				vo.setBoardInfo(rs.getString("board_info"));
				vo.setUserId(rs.getString("user_name"));
				vo.setUserName(rs.getString("user_id"));
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
