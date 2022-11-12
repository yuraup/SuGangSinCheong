import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PDirectoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory departmentTable;
	private PLecture lectureTable;
	
	String title;
	Vector<VDirectory> vDirectories;
	
	Vector<String> row;
	public PDirectoryPanel() {	 
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);

		JPanel subPanel1 = new JPanel();
		
		layoutManager = new BoxLayout(subPanel1, BoxLayout.X_AXIS);
		subPanel1.setLayout(layoutManager);
		
		this.setBackground(new Color(255, 204, 213));
		title ="캠퍼스";
		JScrollPane scrollPane = new JScrollPane();
		this.campusTable = new PDirectory();
		scrollPane.setViewportView(this.campusTable);
		subPanel1.add(scrollPane);

		title ="대학";
		scrollPane = new JScrollPane();
		this.collegeTable = new PDirectory();
		scrollPane.setViewportView(this.collegeTable);
		subPanel1.add(scrollPane);
		
		title ="학과";
		scrollPane = new JScrollPane();
		this.departmentTable = new PDirectory();
		scrollPane.setViewportView(this.departmentTable);
		subPanel1.add(scrollPane);
		
		this.add(subPanel1);
		
		JPanel subPanel2 = new JPanel();
		layoutManager = new BoxLayout(subPanel2, BoxLayout.Y_AXIS);
		subPanel2.setLayout(layoutManager);

		scrollPane = new JScrollPane();
		this.lectureTable = new PLecture();
		scrollPane.setViewportView(this.lectureTable);
		subPanel2.add(scrollPane);

		this.add(subPanel2);		

		
		String fileName = "root";
		fileName = this.campusTable.setData(fileName);
		fileName = this.collegeTable.setData(fileName);
		fileName = this.departmentTable.setData(fileName);
		this.lectureTable.setData(fileName);
		
	}
	
	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		public PDirectory() {
			Vector<String> header = new Vector<String>();
			header.add(title);
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
			
		}
		
		public String setData(String fileName) {
			SDirectory sDirectory = new SDirectory();
			Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName);

			for (VDirectory vDirectory: vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);		
			}
			this.setRowSelectionInterval(0, 0);
			return vDirectories.get(0).getFileName();
		}
	}
	
	private class PLecture extends JTable {
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		public PLecture() {
			Vector<String> header = new Vector<String>();
			header.add("강좌번호");
			header.add("강좌명");
			header.add("담당교수");
			header.add("학점");
			header.add("시간");
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
			
		}
		
		public void setData(String fileName) {
			SLecture sLecture = new SLecture();
			Vector<VLecture> vLectures = sLecture.getLectures(fileName);

			for (VLecture vLecture: vLectures) {
				Vector<String> row = new Vector<String>();
				row.add(vLecture.getId());
				row.add(vLecture.getName());
				row.add(vLecture.getProfessor());
				row.add(vLecture.getCredit());
				row.add(vLecture.getTime());
				this.tableModel.addRow(row);		
			}
			this.setRowSelectionInterval(0, 0);
		}
	}
}


