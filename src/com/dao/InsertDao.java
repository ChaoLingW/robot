package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
/**
 * 
* @ClassName: InsertDao  
* @Description: TODO
* @author chaoling  
* @date 2018年6月15日
 */

public class InsertDao {
	
	int no = -1;
	Connection  con = new DBConnection().getConnection();	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String data = df.format(System.currentTimeMillis());

	
	public static int  insertRobotDao(String  s) {
		int no = -1;
		Connection  con = new DBConnection().getConnection();	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data = df.format(System.currentTimeMillis());
				String sql = "insert into content (content,data,status)values(?,?,?)";									
		
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,s);
				pstmt.setString(2, data);
				pstmt.setInt(3, 1);
			
				pstmt.executeUpdate();
	
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					no = Long.valueOf(rs.getLong(1)).intValue();
				}
	
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return no;
	}
public static int insertUserDao(String  s) {
	int no = -1;
	Connection  con = new DBConnection().getConnection();	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String data = df.format(System.currentTimeMillis());

		String sql = "insert into content (content,data,status)values(?,?,?)";									
			try {
		
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,s);
				pstmt.setString(2, data);
				pstmt.setInt(3, 2);
			
				pstmt.executeUpdate();
				
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					no = Long.valueOf(rs.getLong(1)).intValue();
				}
	
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return no;
	}
}
