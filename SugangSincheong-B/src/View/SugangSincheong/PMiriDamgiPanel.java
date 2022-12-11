package View.SugangSincheong;

import java.util.Vector;

import Service.SMiriDamgi;
import ValueObject.VLecture;
import ValueObject.VMiriDamgi;

public class PMiriDamgiPanel extends PLectureTable {
	SMiriDamgi sMiriDamgi = new SMiriDamgi();
	boolean checkLog;
	
	public PMiriDamgiPanel() {
		super("department/");
		checkLog = sMiriDamgi.initCheck();
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

	public void addLectures(Vector<VLecture> lectures) { //데이터를 model까지 보낸다.
		VMiriDamgi vMiridamgi = new VMiriDamgi(); 
		sMiriDamgi = new SMiriDamgi(); 
		
		vMiridamgi.setId(lectures.get(0).getId());
		vMiridamgi.setName(lectures.get(0).getName());
		vMiridamgi.setProfessor(lectures.get(0).getProfessor());
		vMiridamgi.setCredit(lectures.get(0).getCredit());
		vMiridamgi.setTime(lectures.get(0).getTime());
		
		sMiriDamgi.addMiridamgi(vMiridamgi);
		setLectures(vMiridamgi);
	}

	public Vector<VLecture> getSelectedLecture() { //선택값을 반환 
		return this.getData(this.getSelectedRows()[0]); 
	}
}
