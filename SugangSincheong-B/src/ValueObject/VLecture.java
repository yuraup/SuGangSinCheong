package ValueObject;
import java.util.ArrayList;
import java.util.Scanner;

public class VLecture {
	private String id;
	private	String name;
	private String professor;
	private String credit;
	private String time;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) { 
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getProfessor() {
		return professor;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getCredit() {
		return credit;
	}
	
	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public void read(Scanner scanner) {
		this.id = scanner.next();
		this.name = scanner.next();
		this.professor = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
		
	}
	
	public void setData(ArrayList<String> LectureData) {
		this.id = LectureData.get(0);
		this.name = LectureData.get(1);
		this.professor = LectureData.get(2);
		this.credit = LectureData.get(3);
		this.time = LectureData.get(4);
	}
	
	
}
