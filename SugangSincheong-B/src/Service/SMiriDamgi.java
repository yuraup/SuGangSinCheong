package Service;


import java.util.Vector;

import Entity.EMiriDamgi;
import ValueObject.VMiriDamgi;

public class SMiriDamgi {
	private EMiriDamgi eMiriDamgi;
	Vector<VMiriDamgi> vMiridamgi;
	
	
	
	public SMiriDamgi() {
		this.eMiriDamgi = new EMiriDamgi();
	}
	
	public boolean initCheck() {
		boolean checkLog = eMiriDamgi.checkInitMiridamgi();
		System.out.println("S checkLog:" + checkLog);
		return checkLog;
	}

	public Vector<VMiriDamgi> getInitMiridamgi() { //
		this.vMiridamgi = this.eMiriDamgi.getMiridamgiFile();
		return this.vMiridamgi; //미리담기 내역을 반환한다. 
	}

	public void addMiridamgi(VMiriDamgi vMiridamgi) { //log를 파일에 저장하기 위해 만든 메소드
		this.eMiriDamgi.getLectures(vMiridamgi);
		
	}
}
