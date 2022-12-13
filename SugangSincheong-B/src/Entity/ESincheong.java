package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VLecture;
import ValueObject.VSincheong;

public class ESincheong {

	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	private boolean checkLog;
	
	public boolean checkInitMiridamgi() { //수강신청 파일에 초기 데이터가 있는지 체크한다. 
		try {
			checkLog = false;
			File file = new File("sugangLog/sugangLog");
			Scanner scanner = new Scanner(file);
			
			// file read
			while (scanner.hasNext()) {
				this.id = scanner.next();
				this.name = scanner.next();
				this.professor = scanner.next();
				this.credit = scanner.next();
				this.time= scanner.next();	
				checkLog = true;
		}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return checkLog;
	}

	public Vector<VSincheong>  getMiridamgiFile() { //초기 데이터를 스캔해 가지고 온다. 
		Vector<VSincheong> row = new Vector<VSincheong>();
		VSincheong vSincheong = null;
		
		try {
			File file = new File("sugangLog/sugangLog");
			Scanner scanner = new Scanner(file);
			
			// file read
			while (scanner.hasNext()) {
				this.id = scanner.next();
				this.name = scanner.next();
				this.professor = scanner.next();
				this.credit = scanner.next();
				this.time= scanner.next();	

				vSincheong = new VSincheong();
				vSincheong.setId(this.id);
				vSincheong.setName(this.name);
				vSincheong.setProfessor(this.professor);
				vSincheong.setCredit(this.credit);
				vSincheong.setTime(this.time);

				row.add(vSincheong);
		}
			if (scanner.hasNext() == false) { //이제 만약 내용이 없다면 
				scanner.close();		
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return row;	
	}
	
	public void getLectures(VSincheong vSincheong) { //목록에서 선택된 내용을 가져와 수강신청 파일에 저장한다.
		try {
			this.id = vSincheong.getId();
			this.name = vSincheong.getName();
			this.professor = vSincheong.getProfessor();
			this.credit = vSincheong.getCredit();
			this.time = vSincheong.getTime();
				
			File file = new File("sugangLog/sugangLog");
			FileWriter fileWriter = new FileWriter(file, true);
			
			String str = id+" "+name+" "+professor+" "+credit+" "+time+"\n";
			fileWriter.write(str);
			
			fileWriter.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void deleteLog(Vector<VLecture> selectedRow) { // 수강신청에서 선택된 열 삭제 
		String[] separatedText = null;
		  try {
		      //파일 읽기
			    File file = new File("sugangLog/sugangLog");
				Scanner scanner = new Scanner(file); //파일의 경로를 넘김 경로 읽음  
				
				File newFile = new File("sugangLog/sugangLog"); //덮어 쓸 새 파일 
				FileWriter fw = new FileWriter(newFile);
				
				// file read
				while (scanner.hasNext()) { //read == true
					String text = scanner.nextLine(); //한 줄 읽기
					separatedText = text.split(" "); //공백 기준으로 한 줄을 나눠 담기
					
					if (!separatedText[0].equals(selectedRow.get(0).getId())) { //같지 않은 내용이 안으로 들어감 
						fw.write(text);
						fw.write("\n");
					}
			}
				scanner.close();
				fw.close();
		  }
		  
		  catch (Exception e) {
			  e.printStackTrace();
		  }
	}

	public boolean checkDouble(Vector<VLecture> lectures) { // 신청 내역에 중복되는 열이 있는지 검사한다. 
		boolean checkDoublePoint = false; //중복 체크 변수 
		
	    File file = new File("sugangLog/sugangLog");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				this.id = scanner.next();
				this.name = scanner.next();
				this.professor = scanner.next();
				this.credit = scanner.next();
				this.time= scanner.next();
			}
			scanner.close();
			
			if (!lectures.get(0).getId().equals(this.id)) { //둘이 같지 않을 때 
				checkDoublePoint = true; 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return checkDoublePoint;
	}
}
