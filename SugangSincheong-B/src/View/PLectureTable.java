package View;

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
	      
	      public PLectureTable(String directoryName) {
	    	  this.directoryName = directoryName;
	    	 
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
	         Vector<VLecture> vLectures = sLecture.getLectures(directoryName + fileName);
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
	     
	      public Vector<VLecture> getData(int index) {
	    	  	  ArrayList<String> selectData = new ArrayList<>();
	    	  	  for(int i =0;i<5; i++) {
	    	  		  selectData.add(this.tableModel.getValueAt(index, i).toString());
	    	  		  System.out.println(this.tableModel.getValueAt(index, i).toString());
	    	  	  }
	    		  VLecture VLectureData = new VLecture();
	    		  VLectureData.setData(selectData);
	    		  Vector<VLecture> a = new Vector<VLecture>();
	    		  a.add(VLectureData);
	    	  return a;
	      }
}
	   