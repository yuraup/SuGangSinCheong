package View.SugangSincheong;

import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Service.SDirectory;
import ValueObject.VDirectory;
import ValueObject.VLecture;

public class PDirectoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ListSelectionHandler listSelectionHandler;
	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory departmentTable;
	
	private PLectureTable lectureTable;
	
	String title = "";
	
	   public PDirectoryPanel() { //GUI부분 
		      LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		      this.setLayout(layoutManager);
		      
		      this.listSelectionHandler = new ListSelectionHandler();
		      
		      JPanel subPanel1 = new JPanel(); 
		      
			      layoutManager = new BoxLayout(subPanel1, BoxLayout.X_AXIS);
			      subPanel1.setLayout(layoutManager);
			      
			      
			      title ="캠퍼스";
			      JScrollPane scrollPane = new JScrollPane();
			      this.campusTable = new PDirectory("root/"); //directoryName 추가 
			      scrollPane.setViewportView(this.campusTable);
			      this.campusTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
			      //이벤트 핸들러 모델에 붙임
			      subPanel1.add(scrollPane);
			      
			      title ="대학";
			      scrollPane = new JScrollPane();
			      this.collegeTable = new PDirectory("campus/");
			      scrollPane.setViewportView(this.collegeTable);
			      this.collegeTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			      subPanel1.add(scrollPane);
			
			      title ="학과";
			      scrollPane = new JScrollPane();
			      this.departmentTable = new PDirectory("college/");
			      scrollPane.setViewportView(this.departmentTable);
			      this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
			      subPanel1.add(scrollPane);
		   
		      this.add(subPanel1);

		      JPanel subPanel2 = new JPanel(); //아래 판넬 
		      
			      layoutManager = new BoxLayout(subPanel2, BoxLayout.Y_AXIS);
			      subPanel2.setLayout(layoutManager);
			      
			      scrollPane = new JScrollPane();
			      this.lectureTable = new PLectureTable("department/");
			      scrollPane.setViewportView(this.lectureTable);
			      this.lectureTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
			      subPanel2.add(scrollPane);
		      this.add(subPanel2);
		 
		      this.updateTable(null);
		       
		   }
		   
		   private class ListSelectionHandler implements ListSelectionListener { //이벤트 부분 LastIndex 
			      @Override
			      public void valueChanged(ListSelectionEvent event) {
			         //row 클릭시 이벤트 발생 
			       if (!event.getValueIsAdjusting()) { //mouse release ,결과만 봄
			    	   updateTable(event.getSource()); 
			       } else {
			       	} 
			      }
			   }

			private void updateTable(Object selectedTable) { //동작이 가능하도록 
				int[] selectedIndex; //하나만  
				String fileName = null;
				
				if (selectedTable == null) { // 초기 
					this.campusTable.setData("root/");
				} else if (selectedTable == this.campusTable.getSelectionModel()) { //캠퍼스 디렉토리 
					selectedIndex = this.campusTable.getSelectedRows(); 
					
					if (selectedIndex.length > 0) { //조건 줘서 막아버림. 배열 길이가 0이면 아무것도 안 함. 
						fileName =  this.campusTable.getvDirectories().get(selectedIndex[0]).getFileName(); 
						this.collegeTable.setData(fileName);
					}
				} else if (selectedTable == this.collegeTable.getSelectionModel()) { //대학 디렉토리 		
					selectedIndex = this.collegeTable.getSelectedRows();
					if (selectedIndex.length > 0) {
						fileName = this.collegeTable.getvDirectories().get(selectedIndex[0]).getFileName();
						this.departmentTable.setData(fileName);
					}
				} else if (selectedTable == this.departmentTable.getSelectionModel()) {	//학과 디렉토리 		
					selectedIndex = this.departmentTable.getSelectedRows();
					if (selectedIndex.length > 0) {
						fileName = this.departmentTable.getvDirectories().get(selectedIndex[0]).getFileName();
						this.lectureTable.setData(fileName);
					}
				}
//				else if (selectedTable == this.lectureTable) { // 강좌	
//					selectedIndex = this.lectureTable.getSelectedRows();
//					if (selectedIndex.length > 0) {
//						
//					}
//				}
			}
		    
		   private class PDirectory extends JTable { //디렉토리 틀 
		      private static final long serialVersionUID = 1L;

		      private DefaultTableModel tableModel;
		      
		      private Vector<VDirectory> vDirectories;
		      private SDirectory sDirectory;
		      private String directoryName;
		      
		      public PDirectory(String directoryName) {
		    	 this.directoryName = directoryName;
		         Vector<String> header = new Vector<String>(); 
		         header.add(title);
		         
		         this.tableModel = new DefaultTableModel(header, 0);
		         this.setModel(this.tableModel);
		      }
		      
		      public Vector<VDirectory> getvDirectories() {
		    	  return this.vDirectories;
		      }
		      
		      public String setData(String fileName) {
		         this.sDirectory = new SDirectory();
		         this.vDirectories = sDirectory.getDirectories(this.directoryName + fileName);
		         
		         this.tableModel.setNumRows(0);
		         for (VDirectory vDirectory: this.vDirectories) {
		            Vector<String> row = new Vector<String>();
		            row.add(vDirectory.getName());
		            this.tableModel.addRow(row);      
		         }
		         
		         this.setRowSelectionInterval(0, 0);
		         return vDirectories.get(0).getFileName();
		      }
		   }

	public void addLectures(Vector<VLecture> lectures) {
		System.out.println("여기 안 돼 directory lectures:" + lectures);
	}
	public  Vector<VLecture> getSelectedLecture() {
//		System.out.println("aa" + this.lectureTable.getSelectedRows()[]);
		return this.lectureTable.getData(this.lectureTable.getSelectedRows()[0]);
	}
}