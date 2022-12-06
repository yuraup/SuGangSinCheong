package View;

import java.util.Vector;

import ValueObject.VLecture;

public class PMiriDamgiPanel extends PLectureTable {
	public PMiriDamgiPanel() {
		super("department/");
		
		
	}

	private static final long serialVersionUID = 1L;

	public  Vector<VLecture> setLectures (Vector<VLecture> lectures) {
		System.out.println("이유라바보"+lectures.get(0).getId());
		Vector<String> row = new Vector<String>();
        row.add(lectures.get(0).getId());
        row.add(lectures.get(0).getName());
        row.add(lectures.get(0).getProfessor());
        row.add(lectures.get(0).getCredit());
        row.add(lectures.get(0).getTime());
        this.tableModel.addRow(row);
		return lectures;
	}

	public void addLectures(Vector<VLecture> lectures) {
		setLectures(lectures);
	}

	public Vector<VLecture> getSelectedLecture() {

		return null;
	}
}
