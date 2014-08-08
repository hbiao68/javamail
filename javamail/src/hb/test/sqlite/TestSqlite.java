package hb.test.sqlite;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSqlite {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:mydb.db");
			Statement stmt = conn.createStatement();
			
			//stmt.executeUpdate ( " create table user ( id integer primary key, name varchar(32) ); " ) ; //创建一个表，两列
			
			String deleteAllData = "delete from user";
			stmt.execute(deleteAllData);
			
			String addData1 ="insert into user (id,name) values(1,'huangbiao')";
			String addData2 ="insert into user (id,name) values(2,'liumei')";
			
			stmt.executeUpdate(addData1);
			stmt.executeUpdate(addData2);
			
			
			ResultSet rs = stmt.executeQuery("select * from user");
			while(rs.next()){
				String id = rs.getString(1);
				String code= rs.getString(2);
				System.out.println("用户名:" + id + "， 密码:" + code);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}