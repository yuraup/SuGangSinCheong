package Service;

import java.util.Vector;

import Entity.ESincheong;
import ValueObject.VSincheong;

public class SSincheong {
	private ESincheong eSincheong;
	Vector<VSincheong> vSincheong;
	
	public SSincheong() {
		this.eSincheong = new ESincheong();
	}
	
	public boolean initCheck() { //초기 파일 체크 
		boolean checkLog = eSincheong.checkInitMiridamgi();
		return checkLog;
	}

	public Vector<VSincheong> getInitSincheong() { //초기 세팅시 수강신청되었던 목록 반환 
		this.vSincheong = this.eSincheong.getMiridamgiFile();
		return this.vSincheong; 
	}

	public void addMiridamgi(VSincheong vSincheong) { //log를 파일에 저장하기 위해 만든 메소드
		this.eSincheong.getLectures(vSincheong);
		
	}
}
