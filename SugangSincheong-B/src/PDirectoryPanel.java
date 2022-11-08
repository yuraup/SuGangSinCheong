import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PDirectoryPanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory majorTable;
	
	String title;
	String nextChoice = "seoul";
	String majorChoice = "ict";
	Vector<VDirectory> vDirectories;
	
	Vector<String> row;
	public PDirectoryPanel() {	
		this.setBackground(new Color(255, 204, 213));
		title ="캠퍼스";
		this.campusTable = new PDirectory();
		JScrollPane scrollPane = new JScrollPane();
		this.campusTable = new PDirectory();
		scrollPane.setViewportView(campusTable);
		this.campusTable.setData("root");
		this.add(scrollPane);
		campusTable.addMouseListener(this);
		
		
		
		title ="대학";
		this.collegeTable = new PDirectory();
		scrollPane = new JScrollPane();
		this.collegeTable = new PDirectory();
		scrollPane.setViewportView(collegeTable);
		this.collegeTable.setData(nextChoice);
		this.add(scrollPane);
//		collegeTable.addMouseListener(this);
		
		title ="학과";
		this.majorTable = new PDirectory();
		scrollPane = new JScrollPane();
		this.majorTable = new PDirectory();
		
		scrollPane.setViewportView(majorTable);
		this.majorTable.setData("ict");
		this.add(scrollPane);
		
	}
	
	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;
		
		DefaultTableModel tableModel;
		public PDirectory() {
			Vector<String> header = new Vector<String>();
			header.add(title);
			this.tableModel = new DefaultTableModel(header , 0);
			this.setModel(this.tableModel);
		}
		
		public void setData(String fileName) {
			SDirectory sDirectory = new SDirectory();
			vDirectories = sDirectory.getDirectories(fileName);
			
			for (VDirectory vDirectory: vDirectories) {
				row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowCampusIndex = campusTable.getSelectedRow();
//		int columnIndex = campusTable.getSelectedColumn();
		int rowCollegeIndex = collegeTable.getSelectedRow();
		
		if (rowCampusIndex == 0) {
			nextChoice = "yongin";
			this.collegeTable.setData(nextChoice);
		} else if (rowCampusIndex == 1) { 
			nextChoice = "seoul";
			this.collegeTable.setData(nextChoice);

//			if(rowCollegeIndex == 0) {
//			majorChoice = "generalS";
//			this.MajorTable.setData(majorChoice);
//		} else if (rowCollegeIndex == 1) {
//			majorChoice = "ict";
//			this.MajorTable.setData(majorChoice);
//		}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}


