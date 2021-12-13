package com.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO
{
	private String jdbc_driver = "oracle.jdbc.driver.OracleDriver";

	private String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

	private String connectId = "hr";

	private String connectPwd = "hr";

	public Connection conn;

	public Statement stmt;

	public PreparedStatement psmt;

	public ResultSet rs;

	public void connect()
	{
		try
		{
			Class.forName(this.jdbc_driver);
			this.conn = DriverManager.getConnection(this.jdbc_url, this.connectId, this.connectPwd);
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void disconnect()
	{
		try
		{
			if (this.rs != null)
				this.rs.close();
			if (this.stmt != null)
				this.stmt.close();
			if (this.psmt != null)
				this.psmt.close();
			if (this.conn != null)
				this.conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
