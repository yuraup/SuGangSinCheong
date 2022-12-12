package View.SugangSincheong;

import java.util.Vector;

import javax.swing.JOptionPane;

import Service.SMiriDamgi;
import ValueObject.VLecture;
import ValueObject.VMiriDamgi;

public class PMiriDamgiPanel extends PLectureTable {
	SMiriDamgi sMiriDamgi = new SMiriDamgi();
	boolean checkLog;
	
	public PMiriDamgiPanel() {
		super("department/");
		checkLog = sMiriDamgi.initCheck(); //파일에 내역이 있는지 
		if (checkLog == true) {
			setInitMiridamgi();
		}
	}

	private static final long serialVersionUID = 1L;

	public void setInitMiridamgi () { //예전 내역을 파일에서 불러와서 화면에 그린다.
		Vector<VMiriDamgi> initData = sMiriDamgi.getInitMiridamgi();
		
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
	
	public void setLectures (VMiriDamgi vMiridamgi) { //실행 중 새로 선택한 항목을 화면에 그린다.
		Vector<String> row = new Vector<String>();

        row.add(vMiridamgi.getId());
        row.add(vMiridamgi.getName());
        row.add(vMiridamgi.getProfessor());
        row.add(vMiridamgi.getCredit());
        row.add(vMiridamgi.getTime());
        
        this.tableModel.addRow(row);
	}
	
	public void addLectures(Vector<VLecture> lectures) { //추가한 데이터를 model까지 보낸다.
		VMiriDamgi vMiridamgi = new VMiriDamgi(); 
		sMiriDamgi = new SMiriDamgi(); 
		boolean checkDoublePoint = sMiriDamgi.checkDouble(lectures);
		
		if (checkDoublePoint) { //  true면 추가할 수 있게 
			JOptionPane.showMessageDialog(null, "선택하신 강좌가 미리담기에 추가되었습니다.");
			vMiridamgi.setId(lectures.get(0).getId());
			vMiridamgi.setName(lectures.get(0).getName());
			vMiridamgi.setProfessor(lectures.get(0).getProfessor());
			vMiridamgi.setCredit(lectures.get(0).getCredit());
			vMiridamgi.setTime(lectures.get(0).getTime());
			
			sMiriDamgi.addMiridamgi(vMiridamgi); // 새로 추가 S
			setLectures(vMiridamgi); //UI 부분 
		} else {
			JOptionPane.showMessageDialog(null, "선택하신 강좌가 미리담기에 이미 존재합니다.");
		}
	}

	public Vector<VLecture> getSelectedLecture() { //선택값을 반환 
		return this.getData(this.getSelectedRows()[0]); 
	}

	public void deleteLectures() { //삭제한 내용 변경 함수 
		Vector<VLecture> selectedRow = this.getData(this.getSelectedRows()[0]);  //선택한 row 
	    this.tableModel.removeRow(this.getSelectedRows()[0]); //UI에서 row 삭제 
		sMiriDamgi.deleteLog(selectedRow); // 파일에서 row 삭제 
		
	}
}
