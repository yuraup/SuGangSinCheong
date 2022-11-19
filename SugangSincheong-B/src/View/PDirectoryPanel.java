package View;

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
import Service.SLecture;
import ValueObject.VDirectory;
import ValueObject.VLecture;

public class PDirectoryPanel extends JPanel {
   private static final long serialVersionUID = 1L;
   
   private ListSelectionHandler listSelectionHandler;
   
   private PDirectory campusTable;
   private PDirectory collegeTable; 
   private PDirectory departmentTable;
   private PLecture lectureTable;
   String title = "";
   
   public PDirectoryPanel() {
      LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
      this.setLayout(layoutManager);
      
      this.listSelectionHandler = new ListSelectionHandler();
      
      JPanel subPanel1 = new JPanel(); 
      
      layoutManager = new BoxLayout(subPanel1, BoxLayout.X_AXIS);
      subPanel1.setLayout(layoutManager);
      
      title ="캠퍼스";
      JScrollPane scrollPane = new JScrollPane();
      this.campusTable = new PDirectory();
      scrollPane.setViewportView(this.campusTable);
      this.campusTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
      //이벤트 핸들러 모델에 붙임
      subPanel1.add(scrollPane);
      
      title ="대학";
      scrollPane = new JScrollPane();
      this.collegeTable = new PDirectory();
      scrollPane.setViewportView(this.collegeTable);
      this.collegeTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
      System.out.println("궁금:" + this.listSelectionHandler);
      subPanel1.add(scrollPane);

      title ="학과";
      scrollPane = new JScrollPane();
      this.departmentTable = new PDirectory();
      scrollPane.setViewportView(this.departmentTable);
      this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
      System.out.println("궁금2:" + this.listSelectionHandler);
      subPanel1.add(scrollPane);
   
      this.add(subPanel1);

      JPanel subPanel2 = new JPanel(); //아래 판넬 
      
      layoutManager = new BoxLayout(subPanel2, BoxLayout.Y_AXIS);
      subPanel2.setLayout(layoutManager);
      
      scrollPane = new JScrollPane();
      this.lectureTable = new PLecture();
      scrollPane.setViewportView(this.lectureTable);
      this.lectureTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
      subPanel2.add(scrollPane);
      this.add(subPanel2);
 
      this.updateTable(null, 0);
      
   }
   
   private class ListSelectionHandler implements ListSelectionListener {
	      @Override
	      public void valueChanged(ListSelectionEvent event) {
	         //row 클릭시 이벤트 발생 
	        
	       if (!event.getValueIsAdjusting()) { //mouse release ,결과만 봄
	    	   System.out.println(event.getSource().toString());
	    	   int rowIndex = event.getLastIndex();
	    	   updateTable(event.getSource(), rowIndex); //여기 맞나 
	       } else {
	    	  
	       } 
	      }
	   }
   
   private void updateTable (Object object, int selectedIndex) {//틀 유지,초기화 할=기 
	   String fileName = "null";
	   	if (object == null) {
	   		  fileName = "root";
	   		System.out.println("root1" + fileName);
		      fileName = this.campusTable.setData(fileName);
		      System.out.println("dhdldld" + fileName);
		      fileName = this.collegeTable.setData(fileName);
		      fileName = this.departmentTable.setData(fileName);
		      this.lectureTable.setData(fileName);
		      
	   	} else if (object == this.campusTable.getSelectionModel()) {
	   			fileName = this.campusTable.getvDirectories().get(selectedIndex).getFileName();
	   			fileName = this.collegeTable.setData(fileName);
	   			fileName = this.departmentTable.setData(fileName);
		    	this.lectureTable.setData(fileName);
		      
	   	} else if (object == this.collegeTable.getSelectionModel()) {
	   			fileName = this.campusTable.getvDirectories().get(selectedIndex).getFileName();
	   			fileName = this.departmentTable.setData(fileName);
	   			this.lectureTable.setData(fileName);
	   			
	   	} else if (object == this.departmentTable.getSelectionModel()) {
	   		fileName = this.campusTable.getvDirectories().get(selectedIndex).getFileName();
	   		this.lectureTable.setData(fileName);
	   
	   	} else if (object == this.lectureTable.getSelectionModel()) 
	   	{
	   
	   	}
   }
   
   private class PDirectory extends JTable {
      private static final long serialVersionUID = 1L;
      Vector<VDirectory> vDirectories;

      private DefaultTableModel tableModel;
      public PDirectory() {
         Vector<String> header = new Vector<String>(); 
         header.add(title);
         
         this.tableModel = new DefaultTableModel(header, 0);
         this.setModel(this.tableModel);
      }
      
      public Vector<VDirectory> getvDirectories() {
    	  return this.vDirectories;
      }
      
      public String setData(String fileName) {
         SDirectory sDirectory = new SDirectory();
         vDirectories = sDirectory.getDirectories(fileName);
         this.tableModel.setNumRows(0);
         for (VDirectory vDirectory: this.vDirectories) {
            Vector<String> row = new Vector<String>();
            row.add(vDirectory.getName());
            this.tableModel.addRow(row);      
         }
//         this.setRowSelectionInterval(0, 0);
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
         header.add("학년");
         header.add("시간");
         
         this.tableModel = new DefaultTableModel(header, 0);
         this.setModel(this.tableModel);
      }
      
      public void setData(String fileName) {
         SLecture sLecture = new SLecture();
         Vector<VLecture> vLectures = sLecture.getLectures(fileName);
         this.tableModel.setNumRows(0);
         
         for (VLecture vLecture: vLectures) {
            Vector<String> row = new Vector<String>();
            row.add(vLecture.getId());
            row.add(vLecture.getName());
            row.add(vLecture.getProfessor());
            row.add(vLecture.getCredit());
            row.add(vLecture.getTime());
            this.tableModel.addRow(row);
         }
//         this.setRowSelectionInterval(0, 0); //default selection
      }
   }
}

