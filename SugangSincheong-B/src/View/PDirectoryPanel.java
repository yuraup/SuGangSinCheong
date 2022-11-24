package View;

import java.awt.LayoutManager;
import java.util.ArrayList;
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
   VLecture LectureDatas;
   //2. 선언 return 담을 곳 선언 
   private Vector<VLecture> a;
   
   public PDirectoryPanel() { //GUI부분 
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

      subPanel1.add(scrollPane);

      title ="학과";
      scrollPane = new JScrollPane();
      this.departmentTable = new PDirectory();
      scrollPane.setViewportView(this.departmentTable);
      this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler); 
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
   
   private class ListSelectionHandler implements ListSelectionListener { //이벤트 부분 LastIndex 
	      @Override
	      public void valueChanged(ListSelectionEvent event) {
	         //row 클릭시 이벤트 발생 
	       if (!event.getValueIsAdjusting()) { //mouse release ,결과만 봄
	    	   int rowIndex = event.getLastIndex();
	    	   updateTable(event.getSource(), rowIndex); //여기 맞나
	    	   System.out.println("dd" + event.getSource());
	       } else {
	       	} 
	      }
	   }
   
   private Object updateTable (Object object, int selectedIndex) {//어떤 테이블인지 전달,선택된 인덴스 전달 
//	   System.out.println("오브젝트:" + object + " / 선택된 인덱스: " + selectedIndex );
//	   
	   String fileName = "null";
	   	if (object == null) { //초기 실행시 선택 안 한 상태 
	   		  fileName = "root";
		      fileName = this.campusTable.setData(fileName);
		      fileName = this.collegeTable.setData(fileName);
		      fileName = this.departmentTable.setData(fileName);
		      this.lectureTable.setData(fileName);
		      
	   	} else if (object == this.campusTable.getSelectionModel()) { //캠퍼스 디렉토리
	   			fileName = this.campusTable.getvDirectories().get(selectedIndex).getFileName();
	   			fileName = this.collegeTable.setData(fileName);
	   			fileName = this.departmentTable.setData(fileName);
		    	this.lectureTable.setData(fileName);
		      
	   	} else if (object == this.collegeTable.getSelectionModel()) { //대학 디렉토리 
	   			fileName = this.collegeTable.getvDirectories().get(selectedIndex).getFileName();
	   			fileName = this.departmentTable.setData(fileName);
	   			this.lectureTable.setData(fileName);
	   			
	   	} else if (object == this.departmentTable.getSelectionModel()) { //학과 
	   		fileName = this.departmentTable.getvDirectories().get(selectedIndex).getFileName();
	   		this.lectureTable.setData(fileName);
	   
	   	} else if (object == this.lectureTable.getSelectionModel()) 
	   	{
	   		ArrayList<String> lectureData = new ArrayList<>();
	   		for(int i=0;i<5; i++) {
	   			lectureData.add(this.lectureTable.getModel().getValueAt(selectedIndex, i).toString());
	   		}
	   		LectureDatas = new VLecture(lectureData);
	   		//1. return
	   	}
		return a;
   }
    
   private class PDirectory extends JTable { //디렉토리 틀 
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
   
   private class PLecture extends JTable { //강의 틀 
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
//         this.setRowSelectionInterval(1, 1); //default selection
      }
   }

public void addLectures(Vector<VLecture> lectures) {
	
}

public VLecture getSelectedLecture() {
//3. 선언한 값을 받아와서 리턴한다 . 
	return LectureDatas;
}

}

