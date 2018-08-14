package com.study.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn=getConn();
//		conn.setAutoCommit(false);
//		PreparedStatement pstmt=null;
//		String sql="select woid from mesdb.t_wo_snlist limit 0,1";
//		pstmt=conn.prepareStatement(sql);
//		ResultSet resultSet=pstmt.executeQuery();
//		if (resultSet.next()) {
//			String aString=resultSet.getString("woid");
//			System.out.println(aString);
//		}
//		pstmt.close();
//		conn.commit();
//		conn.close();
		List<String> esns = new ArrayList<String>();
		for (int i = 0; i <300000; i++) {
			esns.add(""+i);
		}
		insertInfo(conn, esns);
		
		

	}
	
	
	public static void insertInfo(Connection conn, List<String> esns) throws SQLException {
		PreparedStatement pstmt=null;
		StringBuffer sbBuffer=new StringBuffer();
		System.out.println("开始时间："+System.currentTimeMillis());
		sbBuffer.append("insert into wmsr.t_temp_table (temp_data) values ");
		for (String string : esns) {
			sbBuffer.append("('"+string+"'),");
		}
		sbBuffer.deleteCharAt(sbBuffer.length() - 1);
		pstmt=conn.prepareStatement(sbBuffer.toString());
		pstmt.executeUpdate();
		pstmt.close();
//		conn.commit();
		conn.close();
		System.out.println("结束时间："+System.currentTimeMillis());
		
	}
	
	
	public void updateLianbiInfo(Connection conn, List<String> esns) throws SQLException {
		PreparedStatement pstmt=null;
		String sql="update sfcr.z_whs_lianbi_info SET remark = 'ViroyalReturn' where sn=?";
		pstmt=conn.prepareStatement(sql);
		for (String string : esns) {
			pstmt.setString(1, string);
			pstmt.addBatch();
		}
		pstmt.executeBatch();
		pstmt.close();
		conn.commit();
		conn.close();
	}
	
	public static void select123 (Connection conn ) throws SQLException {
		PreparedStatement pstmt=null;
		String sql="select woid from mesdb.t_wo_snlist limit 0,1";
		pstmt=conn.prepareStatement(sql);
		ResultSet resultSet=pstmt.executeQuery();
		if (resultSet.next()) {
			String aString=resultSet.getString("woid");
		}
		pstmt.close();
		conn.commit();
		conn.close();
	}
	
	
	
	
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://172.16.171.250:3306/wmsr?useUnicode=true&characterEncoding=UTF-8";
	    String username = "mesmysql";
	    String password = "TEST";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	

}
