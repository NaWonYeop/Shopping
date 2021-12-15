package com.shopping.vo;

public class BoardVO
{
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private String userId;
	public int getBoardId()
	{
		return boardId;
	}
	public void setBoardId(int boardId)
	{
		this.boardId = boardId;
	}
	public String getBoardTitle()
	{
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle)
	{
		this.boardTitle = boardTitle;
	}
	public String getBoardContent()
	{
		return boardContent;
	}
	public void setBoardContent(String boardContent)
	{
		this.boardContent = boardContent;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	
}
