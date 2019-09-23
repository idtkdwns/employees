package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Employees;

public class EmployeesDao {
	public List<Employees> selectEmployListOrderBy(String order) { //오름차순, 내림차순위한 메소드생성
		System.out.println("selectEmployListOrderBy order :" + order);
		List<Employees> list = new ArrayList<Employees>(); //다형성때문에 List로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "";
		if(order.equals("asc")){ //오름차순
			sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees ORDER BY first_name ASC LIMIT 50";
		}else if(order.equals("desc")){ //내림차순
			sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees ORDER BY first_name DESC LIMIT 50";
		}
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Employees> selectEmployeesList(int limit){
		System.out.println("selectEmplyeesList limit : "+limit); //값 확인
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees LIMIT ?";
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery();
			while(rs.next()){
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	public int selectEmployeesCount(){//몇행인지 알기위한 메소드
		int count =0;
		final String sql="SELECT COUNT(*) FROM employees";//바꾸지못한다
		Connection conn= null;
		PreparedStatement stmt= null;
		ResultSet rs=null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt= conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			if(rs.next()){
				count=rs.getInt("COUNT(*)");
			}
		}catch(Exception e){// 자바의 변수 생명주기는 {}다 여기에서 e는 밑에있는e.xxx다
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();//콘솔창에다 예외 출력
			}
		}
		return count;
	}
}
