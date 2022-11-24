package com.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class getColNames {

	public static String get(String schema , String dbname , String dbpass , String tableName) {
		StringBuffer sb = new StringBuffer();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+schema, dbname, dbpass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+tableName);
			ResultSetMetaData rsMetaData = rs.getMetaData();

			int count = rsMetaData.getColumnCount();
			for (int i = 1; i <= count; i++) {
				if(rsMetaData.getColumnType(i) == 4)
					sb.append("int,");
				else
					sb.append("String,");
				
				sb.append(rsMetaData.getColumnName(i) + ",");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
