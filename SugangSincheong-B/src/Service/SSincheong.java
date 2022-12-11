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
	
	public boolean initCheck() {
		boolean checkLog = eSincheong.checkInitMiridamgi();
		System.out.println("S checkLog:" + checkLog);
		return checkLog;
	}

	public Vector<VSincheong> getInitSincheong() { //
		this.vSincheong = this.eSincheong.getMiridamgiFile();
		return this.vSincheong; //미리담기 내역을 반환한다. 
	}

	public void addMiridamgi(VSincheong vSincheong) { //log를 파일에 저장하기 위해 만든 메소드
		this.eSincheong.getLectures(vSincheong);
		
	}
}
