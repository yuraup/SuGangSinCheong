package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VLecture;
import ValueObject.VMiriDamgi;

public class EMiriDamgi {
	
	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	private boolean checkLog;
	
	public boolean checkInitMiridamgi() { // 초기 실행시 미리담기 내역이 있는지 체크한다.
		try {
			checkLog = false; //초기값 
			File file = new File("miridamgiLog/miridamgiLog");
			Scanner scanner = new Scanner(file);
			
			// file read
			while (scanner.hasNext()) { //있으면 
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

	public Vector<VMiriDamgi> getMiridamgiFile() { //초기 실행시 미리담기 데이터를 반환한다. 
		Vector<VMiriDamgi> row = new Vector<VMiriDamgi>();
		VMiriDamgi vMiriDamgi = null;
		
		try {
			File file = new File("miridamgiLog/miridamgiLog");
			Scanner scanner = new Scanner(file);

			// file read
			while (scanner.hasNext()) {
				this.id = scanner.next();
				this.name = scanner.next();
				this.professor = scanner.next();
				this.credit = scanner.next();
				this.time= scanner.next();	

				vMiriDamgi = new VMiriDamgi();
				vMiriDamgi.setId(this.id);
				vMiriDamgi.setName(this.name);
				vMiriDamgi.setProfessor(this.professor);
				vMiriDamgi.setCredit(this.credit);
				vMiriDamgi.setTime(this.time);
				
				row.add(vMiriDamgi);
		}
			if (scanner.hasNext() == false) {
				scanner.close();		
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;	
	}
	
	public void getLectures(VMiriDamgi vMiridamgi) { //목록에서 선택된 내용을 가져와 미리담기 파일에 저장한다. 
		try {
			this.id = vMiridamgi.getId();
			this.name = vMiridamgi.getName();
			this.professor = vMiridamgi.getProfessor();
			this.credit = vMiridamgi.getCredit();
			this.time = vMiridamgi.getTime();
				
			File file = new File("miridamgiLog/miridamgiLog");
			FileWriter fileWriter = new FileWriter(file, true);
			
			String str =id+" "+name+" "+professor+" "+credit+" "+time+"\n";
			fileWriter.write(str);
			
			fileWriter.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void deleteLog(Vector<VLecture> selectedRow) { // 미리담기의 선택된 항목을 삭제한다.  
		String[] separatedText = null; //아이디 비교를 위해 
		
		  try {
		      //파일 읽기
			    File file = new File("miridamgiLog/miridamgiLog");
				Scanner scanner = new Scanner(file); 
				
				System.out.println(" ") ;
				File newFile = new File("miridamgiLog/miridamgiLog"); //덮어 쓸 새 파일 
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

	public boolean checkDouble(Vector<VLecture> lectures) { // 미리담기 파일 데이터 중복 체크 
		boolean checkDoublePoint = false; //중복 체크 변수 
		
	    File file = new File("miridamgiLog/miridamgiLog");
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
			
			if (!lectures.get(0).getId().equals(this.id)) { //둘이 같지 않을 때 (아이디) 
				checkDoublePoint = true; 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return checkDoublePoint;
	}
}