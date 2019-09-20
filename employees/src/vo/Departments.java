package vo;

public class Departments {
	private String deptNo;//제한자 선언
	private String deptName;
	public String getDeptNo() {//deptNo메소드를 가져온다
		return deptNo;//되돌려준다
	}
	public String getDeptName() {//deptName메소드를 가져온다
		return deptName;
	}
	public void setDeptNo(String deptNo) {//넣어준다 
		this.deptNo = deptNo;//자기자신을
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
