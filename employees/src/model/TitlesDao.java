package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;

public class TitlesDao{
	public List<String> selectTitlesListDistinct(){
		List<String> list=new ArrayList<String>();
				int count=0;
		Connection conn= null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		String sql="SELECT COUNT(*) cnt FROM titles";//쿼리 생성
		try {//예외 발생을 찾는다
			conn=DBHelper.getConnection();//DBHelper에서 받아올거다,리턴타입이있는걸줄임
			stmt= conn.prepareStatement(sql);//쿼리  실행
			rs=stmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("cnt");		
			}
		} catch(Exception e) {//예외 처리
			e.printStackTrace();//에러내용 
		} finally {//무조건실행
			DBHelper.close(rs, stmt, conn);
			}
		return list;//돌려줌
	}
	public int selectTitlesRowCount(){
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM titles";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return count;
	}
}
