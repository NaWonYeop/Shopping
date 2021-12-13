package com.shopping.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.vo.BoardVO;
import com.shopping.vo.ItemBoardVO;

public class ItemBoardDAO extends DAO
{
	//삭제
		public void delete(int bId)
		{
			String sql="delete from item_board where ITEM_ID=?";
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
		public void update(ItemBoardVO vo)
		{
			String sql="update item_board set"
					+ " ITEM_NAME=nvl(?,ITEM_NAME),"
					+ " ITEM_INFO=nvl(?,ITEM_INFO),"
					+ " ITME_VAL=nvl(?,ITME_VAL),"
					+ " ITEM_IMG=nvl(?,ITEM_IMG)"
					+ " where ITEM_ID=?";
			connect();
			
			try
			{
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, vo.getItemName());
				psmt.setString(2, vo.getItemInfo());
				psmt.setInt(3, vo.getItemVal());
				psmt.setString(4, vo.getItemImg());
				psmt.setInt(5, vo.getItemId());
				
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
		public void insert(ItemBoardVO vo)
		{
			String idsql="select itembd_seq.nextval from dual";
			String insql="insert into item_board values(?,?,?,?,?)";
			
			int seq=-1;
			try
			{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(idsql);
				if(rs.next())
					seq=rs.getInt(1);
				psmt=conn.prepareStatement(insql);
				psmt.setInt(1, seq);
				psmt.setString(2, vo.getItemName());
				psmt.setString(3, vo.getItemInfo());
				psmt.setInt(4, vo.getItemVal());
				psmt.setString(5, vo.getItemImg());
				
				int r=psmt.executeUpdate();
				System.out.println(r+"건 입력");
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//단건조회
		public ItemBoardVO searchone(int boardId) {
			
			String sql="select * from item_board where item_id=?";
			connect();
			
			try
			{
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, boardId);
				rs=psmt.executeQuery();
				while(rs.next())
				{
					ItemBoardVO vo=new ItemBoardVO();
					vo.setItemId(rs.getInt("item_id"));
					vo.setItemName(rs.getString("item_name"));
					vo.setItemInfo(rs.getString("item_info"));
					vo.setItemVal(rs.getInt("item_val"));
					vo.setItemImg(rs.getString("item_img"));				
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
		public List<ItemBoardVO> boardList(){
			List<ItemBoardVO> list= new ArrayList<>();
			String sql="select * from item_board order by 1";
			connect();
			
			try
			{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					ItemBoardVO vo=new ItemBoardVO();
					vo.setItemId(rs.getInt("item_id"));
					vo.setItemName(rs.getString("item_name"));
					vo.setItemInfo(rs.getString("item_info"));
					vo.setItemVal(rs.getInt("item_val"));
					vo.setItemImg(rs.getString("item_img"));					
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
