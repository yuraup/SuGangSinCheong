package Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VLecture;

public class ELecture {
	String fileName;
	
	public Vector<VLecture> getLectures(String fileName) { //파일 이름 받음 
		this.fileName = fileName;
		Vector<VLecture> vLectures = new Vector<VLecture>(); //벡터 생성 
		
		try {
			Scanner scanner = new Scanner(new File("directory/"+fileName)); //스캐너로 읽음 
			while (scanner.hasNext()) {  // true면 
				VLecture vLecture = new VLecture();
				vLecture.read(scanner); //스캐너로 읽은 값을 저장 
				vLectures.add(vLecture); //위 값을 배열로 저장 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vLectures; //배열로 반환 
	}
}
