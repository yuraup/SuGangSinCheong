package ValueObject;

import java.util.ArrayList;
import java.util.Vector;

public class VMiriDamgi {
	private String id;
	private String name;
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

	public void read(Vector<VLecture> lectures) { //읽기 
		this.id = lectures.get(0).getId();
		this.name = lectures.get(0).getName();
		this.professor = lectures.get(0).getProfessor();
		this.credit = lectures.get(0).getCredit();
		this.time = lectures.get(0).getTime();
	}
	
	public void setData(ArrayList<String> LectureData) { //바꾸기 
		this.id = LectureData.get(0);
		this.name = LectureData.get(1);
		this.professor = LectureData.get(2);
		this.credit = LectureData.get(3);
		this.time = LectureData.get(4);
	}
}
