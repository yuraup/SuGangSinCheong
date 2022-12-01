package View;

import java.util.Vector;

import ValueObject.VLecture;

public class PMiriDamgiPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;
	
	public PMiriDamgiPanel() {
		// TODO Auto-generated constructor stub
	}
	
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
