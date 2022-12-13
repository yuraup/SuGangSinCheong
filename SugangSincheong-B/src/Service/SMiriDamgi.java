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
	
	public boolean initCheck() { //초기 파일의 데이터가 있는지 체크 
		boolean checkLog = eMiriDamgi.checkInitMiridamgi();
		return checkLog;
	}

	public Vector<VMiriDamgi> getInitMiridamgi() {  //전에 이미 담았던 미리담기 내역을 반환한다. 
		this.vMiridamgi = this.eMiriDamgi.getMiridamgiFile();
		return this.vMiridamgi; 
	}

	public void addMiridamgi(VMiriDamgi vMiridamgi) { //목록에서 선택한 열을 미리담기 파일에 저장한다. 
		this.eMiriDamgi.getLectures(vMiridamgi);
		
	}

	public void deleteLog(Vector<VLecture> selectedRow) { //미리담기 파일에서 선택된 열을 삭제한다. 
		this.eMiriDamgi.deleteLog(selectedRow);
	}

	public boolean checkDouble(Vector<VLecture> lectures) { //미리담기 파일을 탐색해 중복 체크 
		boolean checkDoublePoint = eMiriDamgi.checkDouble(lectures);
		return checkDoublePoint;
	}
}
