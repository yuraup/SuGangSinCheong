package View.SugangSincheong;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Service.SLecture;
import ValueObject.VLecture;

	public class PLectureTable extends JTable{
	      private static final long serialVersionUID = 1L;
	      private String directoryName;
	      DefaultTableModel tableModel;
	      
	      public PLectureTable(String directoryName) { //폴더 이름 받음 
	    	  this.directoryName = directoryName;
	    	 
	         Vector<String> header = new Vector<String>();  //머릿말 
	         header.add("강좌번호");
	         header.add("강좌명");
	         header.add("담당교수");
	         header.add("학년");
	         header.add("시간");
	         
	         this.tableModel = new DefaultTableModel(header, 0);
	         this.setModel(this.tableModel);
	      }
	      
	      public void setData(String fileName) { //파일 이름 받음 
	         SLecture sLecture = new SLecture();
	         Vector<VLecture> vLectures = sLecture.getLectures(directoryName + fileName); //새 데이터를 받아옴
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
	         this.setRowSelectionInterval(0, 0); //default selection
	     }
	      
	      public void setLectures (VLecture vLecture) { //실행 중 새로 선택한 항목을 화면에 그린다.
	  		Vector<String> row = new Vector<String>();

	          row.add(vLecture.getId());
	          row.add(vLecture.getName());
	          row.add(vLecture.getProfessor());
	          row.add(vLecture.getCredit());
	          row.add(vLecture.getTime());
	          
	          this.tableModel.addRow(row);
	  	}
	     
	      public Vector<VLecture> getData(int index) { //선택된 항목의 값의 데이터를 읽는다. 
	    	  	  ArrayList<String> selectData = new ArrayList<>();
	    	  	  
	    	  	  for(int i =0;i<5; i++) { // index 4까지 lecture 정보를 담기 위한 for문 
	    	  		  selectData.add(this.tableModel.getValueAt(index, i).toString()); //selectData에 값을 담는다. 
	    	  	  }
	    		  VLecture VLectureData = new VLecture();
	    		  VLectureData.setData(selectData); //0~4 
	    		  Vector<VLecture> row = new Vector<VLecture>();
	    		  row.add(VLectureData);
	    	  return row;
	      }
}
	   