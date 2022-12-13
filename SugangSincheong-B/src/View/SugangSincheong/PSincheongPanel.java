package View.SugangSincheong;

import java.util.Vector;

import javax.swing.JOptionPane;

import Service.SSincheong;
import ValueObject.VLecture;
import ValueObject.VSincheong;

public class PSincheongPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;
	
	SSincheong sSincheong = new SSincheong();
	boolean checkLog;
	
	public PSincheongPanel() {
		super("department/");
		checkLog = sSincheong.initCheck();
		
		if (checkLog == true) { //파일의 내용이 있는지 확인 
			setInitMiridamgi();
		}
	}
	
	public void setInitMiridamgi () { //예전 내역을 파일에서 불러와서 화면에 그린다.
		Vector<VSincheong> initData = sSincheong.getInitSincheong();
		
		for (int i = 0; initData.size() > i; i++) {
			Vector<String> row = new Vector<String>(); //초기화를 위해 for문 안에 선언
			  	row.add(initData.get(i).getId());
		        row.add(initData.get(i).getName());
		        row.add(initData.get(i).getProfessor());
		        row.add(initData.get(i).getCredit());
		        row.add(initData.get(i).getTime());
		        
		        this.tableModel.addRow(row);
		}
	}
	
	public void setLectures (VSincheong vSincheong) {
		Vector<String> row = new Vector<String>();
        row.add(vSincheong.getId());
        row.add(vSincheong.getName());
        row.add(vSincheong.getProfessor());
        row.add(vSincheong.getCredit());
        row.add(vSincheong.getTime());
        
        this.tableModel.addRow(row);
	}

	public void addLectures(Vector<VLecture> lectures) {
		VSincheong vSincheong = new VSincheong(); 
		sSincheong = new SSincheong(); 
		boolean checkDoublePoint = sSincheong.checkDouble(lectures);
		
		if (checkDoublePoint) { //  중복 체크가 true면 추가할 수 있게 
			JOptionPane.showMessageDialog(null, "선택하신 강좌가 수강신청 목록에 추가되었습니다.");
			
			vSincheong.setId(lectures.get(0).getId());
			vSincheong.setName(lectures.get(0).getName());
			vSincheong.setProfessor(lectures.get(0).getProfessor());
			vSincheong.setCredit(lectures.get(0).getCredit());
			vSincheong.setTime(lectures.get(0).getTime());
			
			sSincheong.addMiridamgi(vSincheong);
			setLectures(vSincheong); //수강신청에 추가한다. 
		} else {
			JOptionPane.showMessageDialog(null, "선택하신 강좌가 수강신청 목록에 이미 존재합니다.");
		}
	}

	public Vector<VLecture> getSelectedLecture() { //선택 
		return this.getData(this.getSelectedRows()[0]); 
	}

	public void deleteLectures() { //삭제 기능 
		Vector<VLecture> selectedRow = this.getData(this.getSelectedRows()[0]);  //선택한 row 
	    this.tableModel.removeRow(this.getSelectedRows()[0]); //UI row 삭제 
		sSincheong.deleteLog(selectedRow); // 파일 row 삭제 
	}

	public int countSincheong() { //수강신청 카운트 
		Vector<VSincheong> initData = sSincheong.getInitSincheong();
		int rowCount = 0; // 신청 개수 
		for (int i = 0; initData.size() > i; i++) {
		        rowCount += 1; //줄 개수담김 
		}
		return rowCount;
	}
}
