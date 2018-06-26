package com.liuxuan.pilianginsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 此类作为批量添加的用例，有两个方法，运行速度在27左右
 * @author 山贝戊
 *
 */

public class MysqlInsert {
	
	static Connection conn = MysqlLink.getconn();
	static PreparedStatement ps = null;
	
	public static int executeInsert() throws SQLException {
		int i = 0;
		int masSize = 10;
		ps  = conn.prepareStatement("insert into books (id, title, price) values (?, ?, ?)");
		conn.setAutoCommit(false);
		for (int j = 0; j < 15; j++) {
			++i;
			ps.setString(1, "id" + j);
			ps.setString(2, "name" + j);
			ps.setInt(3, j);
			ps.addBatch();
			if (i % masSize == 0) {
				ps.executeBatch();
				conn.commit();
			}
		}
		if (i % masSize != 0) {
			ps.executeBatch();
			conn.commit();
		}
		return i;
	}
	
	public static void executeInsert2() throws SQLException {
		conn.setAutoCommit(false);
		ps  = conn.prepareStatement("insert into books (id, title, price) values (?, ?, ?)");
		for (int j = 0; j < 12; j++) {
			ps.setString(1, "id" + j);
			ps.setString(2, "title" + j);
			ps.setInt(3, j);
			ps.addBatch();
		}
		ps.executeBatch();
		conn.commit();
		ps.close();
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException{
		long begin = System.currentTimeMillis();
		MysqlInsert.executeInsert2();
		long end = System.currentTimeMillis();
		System.out.println("运行时间为: " + (end - begin));
		
//		long begin = System.currentTimeMillis();
//		MysqlInsert.executeInsert();
//		long end = System.currentTimeMillis();
//		System.out.println("运行时间为: " + (end - begin));
	}
}
