package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DBHelper;

public class SalariesDao {
	public Map<String,Long> selectSalariesstatistics(){
		Map<String,Long> map=new HashMap<String,Long>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="SELECT COUNT(salary),SUM(salary),AVG(salary),MAX(salary),MIN(salary),STD(salary) FROM salaries";
		try {//예외 발생을 찾는다
			conn=DBHelper.getConnection();//DBHelper에서 받아올거다, 리턴타입이 있는걸 줄임
			stmt=conn.prepareStatement(sql);//쿼리실행
			rs=stmt.executeQuery();
			if(rs.next()) {
				map.put("count",rs.getLong("COUNT(salary)"));
				map.put("sum",rs.getLong("SUM(salary)"));
				map.put("avg",rs.getLong("AVG(salary)"));
				map.put("max",rs.getLong("MAX(salary)"));
				map.put("min",rs.getLong("MIN(salary)"));
				map.put("std",rs.getLong("STD(salary)"));
			}
			System.out.println("map"+map);//확인작업
		}catch(Exception e) {//예외 처리
			e.printStackTrace();//에러내용 
		} finally {//무조건실행
			DBHelper.close(rs, stmt, conn);
		}
		return null;	
	}
	public int selectSalariesRowCount(){
		int count = 0;
		String sql = "SELECT COUNT(*) cnt FROM salaries";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{//예외 발생을 찾는다
			conn=DBHelper.getConnection();//DBHelper에서 받아올거다, 리턴타입이 있는걸 줄임
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
