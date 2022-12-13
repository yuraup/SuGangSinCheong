package Service;

import java.util.Vector;

import Entity.ESincheong;
import ValueObject.VLecture;
import ValueObject.VSincheong;

public class SSincheong {
	private ESincheong eSincheong;
	Vector<VSincheong> vSincheong;
	
	public SSincheong() {
		this.eSincheong = new ESincheong();
	}
	
	public boolean initCheck() { //초기 파일의 데이터가 있는지 체크 
		boolean checkLog = eSincheong.checkInitMiridamgi();
		return checkLog;
	}

	public Vector<VSincheong> getInitSincheong() { //초기 세팅시 수강신청되었던 목록 반환 
		this.vSincheong = this.eSincheong.getMiridamgiFile();
		return this.vSincheong; 
	}

	public void addMiridamgi(VSincheong vSincheong) { //미리담기에서 선택한 열을 수강신청 파일에 저장한다. 
		this.eSincheong.getLectures(vSincheong);
		
	}

	public void deleteLog(Vector<VLecture> selectedRow) { //선택한 열을 수강신청 파일에서 제거한다. 
		this.eSincheong.deleteLog(selectedRow);
		
	}

	public boolean checkDouble(Vector<VLecture> lectures) { //수강신청 파일을 탐색해 중복 체크 
		boolean checkDoublePoint = eSincheong.checkDouble(lectures);
		return checkDoublePoint;
	}
}
