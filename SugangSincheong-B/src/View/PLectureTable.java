package View;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Service.SLecture;
import ValueObject.VLecture;

public class PLectureTable extends JTable{
		      private static final long serialVersionUID = 1L;
		      DefaultTableModel tableModel;
		      public PLectureTable() {
		    	 
		         Vector<String> header = new Vector<String>(); 
		         header.add("강좌번호");
		         header.add("강좌명");
		         header.add("담당교수");
		         header.add("학년");
		         header.add("시간");
		         
		         this.tableModel = new DefaultTableModel(header, 0);
		         System.out.println("실행됨");
		         this.setModel(this.tableModel);
//		         this.setModel();
		      }
		      
		      public void setData(String fileName) {
		    	  System.out.println("실행d안 됨");
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
		         
		         this.setRowSelectionInterval(0, 0); //default selection
		      }
		   
}
