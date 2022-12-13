package ValueObject;

public class VAccount { //회원 정보 타입 
	private String id;
	private String password;
	private String name;
	private String grade;
	private String department;
	private int studentCode;
	
	public VAccount() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) { 
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}
}
