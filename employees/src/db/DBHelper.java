package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	public static Connection getConnection() throws Exception{//강제예외 발생
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
		return conn;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {//db를 close하는 메소드 생성
		if(rs !=null) {//널이 아닐때
			try{//예외 실행
				rs.close();
			}catch(Exception e){//예외처리
				e.printStackTrace();//에러내용
			}
		}
		if(stmt !=null) {//널이 아닐때
			try{//예외 실행
				stmt.close();
			}catch(Exception e){//예외처리
				e.printStackTrace();//에러내용
			}
		}
		if(conn !=null) {//널이 아닐때
			try{//예외 실행
				conn.close();
			}catch(Exception e){//예외처리
				e.printStackTrace();//에러내용
			}
		}
	}
}
