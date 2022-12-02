package View;

import java.util.Vector;

import ValueObject.VLecture;

public class PMiriDamgiPanel extends PLectureTable {
	public PMiriDamgiPanel() {
		super("department/");
		// TODO Auto-generated constructor stub
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
