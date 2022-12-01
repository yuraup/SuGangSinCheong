package ValueObject;
import java.util.ArrayList;
import java.util.Scanner;

public class VLecture {
	private String id;
	private	String name;
	private String professor;
	private String credit;
	private String time;
	
//	public VLecture(ArrayList<String> LectureData) {
//		this.id = LectureData.get(0);
//		this.name = LectureData.get(1);
//		this.professor = LectureData.get(2);
//		this.credit = LectureData.get(3);
//		this.time = LectureData.get(4);
//	}
//	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProfessor() {
		return professor;
	}

	public String getCredit() {
		return credit;
	}

	public String getTime() {
		return time;
	}

	public void read(Scanner scanner) {
		this.id = scanner.next();
		this.name = scanner.next();
		this.professor = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}
}
