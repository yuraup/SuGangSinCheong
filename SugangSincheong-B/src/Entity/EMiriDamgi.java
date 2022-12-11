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
	
	public void getLectures(VMiriDamgi vMiridamgi) { //미리담기에 적을 내용을 받아와 파일에 저장한다. 
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
	
	public boolean checkInitMiridamgi() {
		try {
			checkLog = false;
			File file = new File("miridamgiLog/miridamgiLog");
			Scanner scanner = new Scanner(file);
			
			// file read
			while (scanner.hasNext()) {
				this.id = scanner.next();
				this.name = scanner.next();
				this.professor = scanner.next();
				this.credit = scanner.next();
				this.time= scanner.next();	
				checkLog = true;
				System.out.println("checkLog 읽음: " + checkLog);
		}
			scanner.close();

			System.out.println("checkLog 안 읽음: " + checkLog);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return checkLog;
	}

	public Vector<VMiriDamgi>  getMiridamgiFile() {
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
//				found = true;
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

	public void deleteLog(Vector<VLecture> selectedRow) {
		  try {
		      //소스 파일읽기;
			    File file = new File("miridamgiLog/miridamgiLog");
				Scanner scanner = new Scanner(file); //파일의 경로를 넘김 경로 읽음  
				
				System.out.println("야옹: "+ scanner.hasNext());
				
				File newFile = new File("miridamgiLog/miridamgiLog"); //새 파일  
				FileWriter fw = new FileWriter(newFile);
				
				// file read
				System.out.println("미야: "+ scanner.hasNext());
				while (scanner.hasNext()) { //read 
					String text1 = scanner.nextLine(); //한 줄 
					String[] nextText1 = text1.split(" "); //배열의 한 값만 id 
					
					if (!nextText1[0].equals(selectedRow.get(0).getId())) { //같지 않은 내용이 안으로 들어감 
						fw.write(text1);
						fw.write("\n");
					}
			}
				scanner.close();
				fw.close();

		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	}
}
