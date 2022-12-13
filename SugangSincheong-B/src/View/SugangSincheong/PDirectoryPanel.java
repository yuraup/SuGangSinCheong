package View.SugangSincheong;

import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Service.SDirectory;
import Service.SLecture;
import ValueObject.VDirectory;
import ValueObject.VLecture;

public class PDirectoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ListSelectionHandler listSelectionHandler;
	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory departmentTable;
	
	private PLectureTable lectureTable;

	int[] selectedIndex; //하나만  
	
	String title = "";
	String fileName = null;
	
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
				else if (selectedTable == this.lectureTable) { // 강좌	
					selectedIndex = this.lectureTable.getSelectedRows();
					if (selectedIndex.length > 0) {
					
					}
				}
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
		   
	public  Vector<VLecture> getSelectedLecture() { //선택된 row를 반환 
		return this.lectureTable.getData(this.lectureTable.getSelectedRows()[0]);
	}
	public void deleteLectures() { // 목록에서 삭제 
//		String fileName = this.lectureTable.getSelectedRows()[0];
		Vector<VLecture> selectedRow = this.lectureTable.getData(this.lectureTable.getSelectedRows()[0]);  //선택한 row 
		System.out.println("P디렉토리 삭제해줘:" + selectedRow.get(0).getName());
		this.lectureTable.tableModel.removeRow(this.lectureTable.getSelectedRows()[0]); //UI에서 row 삭제 
//		sLecture.deleteLog(selectedRow); // 파일에서 row 삭제 
//		
		
	}
	
	public void addLectures(Vector<VLecture> lectures) { // 목록에 추가 
		VLecture vLecture = new VLecture();
		SLecture sLecture = new SLecture();
		
		
		JOptionPane.showMessageDialog(null, "선택하신 강좌가 미리담기에서 삭제되었습니다.");
		vLecture.setId(lectures.get(0).getId());
		vLecture.setName(lectures.get(0).getName());
		vLecture.setProfessor(lectures.get(0).getProfessor());
		vLecture.setCredit(lectures.get(0).getCredit());
		vLecture.setTime(lectures.get(0).getTime());
		
		this.lectureTable.setLectures(vLecture); //UI 부분 
	}
	
	
	
	
	
}