package View;

import java.util.Vector;

import ValueObject.VLecture;

public class PMiriDamgiPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;
	
	public  Vector<VLecture> setLectures (Vector<VLecture> lectures) {
//	            Vector<String> row = new Vector<String>();
//	            row.add(lectures.getId());
//	            row.add(lectures.getName());
//	            row.add(lectures.getProfessor());
//	            row.add(lectures.getCredit());
//	            row.add(lectures.getTime());
//	            this.tableModel.addRow(row);
		return lectures;
	}

	public void addLectures(Vector<VLecture> lectures) {
		setLectures(lectures);
	}

	public Vector<VLecture> getSelectedLecture() {

		return null;
	}
}
