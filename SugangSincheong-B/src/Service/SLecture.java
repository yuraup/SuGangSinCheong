package Service;
import java.util.Vector;

import Entity.ELecture;
import ValueObject.VLecture;

public class SLecture {
	
	private ELecture eLecture;
	
	public SLecture() {
		this.eLecture = new ELecture();
	}

	public Vector<VLecture> getLectures(String fileName) { //파일 네임 전달 
		return this.eLecture.getLectures(fileName);
	}
}
