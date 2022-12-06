package View;

import java.util.Vector;

import ValueObject.VLecture;

public class PSincheongPanel extends PLectureTable {
	public PSincheongPanel() {
		super("department/");
	}

	private static final long serialVersionUID = 1L;
	
	
	public  Vector<VLecture> setLectures (Vector<VLecture> lectures) {
		return lectures;
	}

	public void addLectures(Vector<VLecture> lectures) {
		setLectures(lectures);
	}

	public Vector<VLecture> getSelectedLecture() {
		return null;
	}

}
