package com.shopping.vo;

public class ItemBoardVO
{
	private int boardId;
	private String boardName;
	private String boardInfo;
	private String userId;
	private String userName;
	public int getBoardId()
	{
		return boardId;
	}
	public void setBoardId(int boardId)
	{
		this.boardId = boardId;
	}
	public String getBoardName()
	{
		return boardName;
	}
	public void setBoardName(String boardName)
	{
		this.boardName = boardName;
	}
	public String getBoardInfo()
	{
		return boardInfo;
	}
	public void setBoardInfo(String boardInfo)
	{
		this.boardInfo = boardInfo;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
