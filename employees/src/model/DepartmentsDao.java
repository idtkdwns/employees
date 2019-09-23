package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Departments;

public class DepartmentsDao {
	public List<Departments> selectDepartmentsList(){
		List<Departments> list = new ArrayList<Departments>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="SELECT dept_no,dept_name FROM departments";//쿼리 작성
		try {//예외 발생을 찾기
			Class.forName("org.mariadb.jdbc.Driver");//db연동
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");//db접속
			stmt=conn.prepareStatement(sql);//쿼리입력
			rs=stmt.executeQuery();//쿼리 실행
			while(rs.next()) {
				Departments departments= new Departments();//객체생성
				departments.setDeptNo(rs.getString("dept_no"));//필드값 저장
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments);//list에 추가
			}
		}catch(Exception e){//에러 잡기
			e.printStackTrace();//에러내용
		}finally {//무조건 실행
			try {
				conn.close();//문장 닫기
				stmt.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;//널 값으로 되돌려줌
	}
	public int selectDepartmentsRowCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM departments";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { //
				count = rs.getInt("COUNT(*)");
			}
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
