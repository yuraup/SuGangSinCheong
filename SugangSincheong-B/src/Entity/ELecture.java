package Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VLecture;

public class ELecture {
	String fileName;
	
	public Vector<VLecture> getLectures(String fileName) {
		this.fileName = fileName;
		Vector<VLecture> vLectures = new Vector<VLecture>();
		
		try {
			Scanner scanner = new Scanner(new File("directory/"+fileName)); //파일 구조 변경 
			while (scanner.hasNext()) {  // true면 
				VLecture vLecture = new VLecture();
				vLecture.read(scanner);
				vLectures.add(vLecture);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vLectures;
	}
}
