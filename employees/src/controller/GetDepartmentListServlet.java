package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import vo.Departments;


@WebServlet("/departments/GetDepartmentList")
public class GetDepartmentListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentsDao= new DepartmentsDao();
		List<Departments> list = departmentsDao.selectDepartmentsList();
		
		request.setAttribute("list", list);//다른곳으로 정보를 넘겨주기위해 request객체의 속성 사용,list이름의 list변수저장
		
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
		//jsp 페이지 안에서 다른 jsp 페이지를 호출할 때 사용하는 메소드,forward()[전달하기]는 클라이언트가 요청하면서 전송한 데이터를 그대로 유지한다
	}
}
