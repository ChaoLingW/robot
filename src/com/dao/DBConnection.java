package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
* @ClassName: DBConnection  
* @Description: 数据库链接
* @author chaoling  
* @date 2018年6月15日
 */

public class DBConnection {
	   String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://127.0.0.1:3306/xiaozhushou?useUnicode=true&characterEncoding=utf8";
	    String user = "root";
	    String  password = "";

	    public Connection getConnection(){
	    	Connection con = null;
	        try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return con;
	    }
	   
}
