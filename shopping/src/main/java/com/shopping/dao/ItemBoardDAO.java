package com.shopping.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.vo.ItemBoardVO;

public class ItemBoardDAO extends DAO
{
	public List<ItemBoardVO> memberList(){
		List<ItemBoardVO> list= new ArrayList<>();
		String sql="select * from member order by 1";
		connect();
		
		try
		{
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				ItemBoardVO vo=new ItemBoardVO();
				vo.setBoardId(rs.getInt(""));
				vo.setBoardName(rs.getString(0));
				vo.setBoardInfo(rs.getString(0));
				vo.setUserId(rs.getString(0));
				vo.setUserName(rs.getString(0));
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
