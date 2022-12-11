package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VSincheong;

public class ESincheong {

	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	private boolean checkLog;
	
	public void getLectures(VSincheong vSincheong) { //미리담기에 적을 내용을 받아와 파일에 저장한다. 
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
	
	public boolean checkInitMiridamgi() {
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

	public Vector<VSincheong>  getMiridamgiFile() {
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
//				found = true;
				row.add(vSincheong);
		}
			if (scanner.hasNext() == false) {
				scanner.close();		
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return row;	
	}
}
