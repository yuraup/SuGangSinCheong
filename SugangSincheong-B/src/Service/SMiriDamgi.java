package Service;


import java.util.Vector;

import Entity.EMiriDamgi;
import ValueObject.VLecture;
import ValueObject.VMiriDamgi;

public class SMiriDamgi {
	private EMiriDamgi eMiriDamgi;
	Vector<VMiriDamgi> vMiridamgi;
	
	public SMiriDamgi() {
		this.eMiriDamgi = new EMiriDamgi();
	}
	
	public boolean initCheck() { //초기 파일 체크 
		boolean checkLog = eMiriDamgi.checkInitMiridamgi();
		return checkLog;
	}

	public Vector<VMiriDamgi> getInitMiridamgi() {  //이미 담겼던 미리담기 내역을 반환한다. 
		this.vMiridamgi = this.eMiriDamgi.getMiridamgiFile();
		return this.vMiridamgi; 
	}

	public void addMiridamgi(VMiriDamgi vMiridamgi) { //새로 선택한 항목을 저장하기 위해 만든 메소드
		this.eMiriDamgi.getLectures(vMiridamgi);
		
	}

	public void deleteLog(Vector<VLecture> selectedRow) {
		this.eMiriDamgi.deleteLog(selectedRow);
	}

	public boolean checkDouble(Vector<VLecture> lectures) {
		boolean checkDoublePoint = eMiriDamgi.checkDouble(lectures);
		return checkDoublePoint;
	}
}
