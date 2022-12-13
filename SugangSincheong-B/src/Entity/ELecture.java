package Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VLecture;

public class ELecture {
	public Vector<VLecture> getLectures(String fileName) {
		Vector<VLecture> vLectures = new Vector<VLecture>();
		try {
			Scanner scanner = new Scanner(new File("directory/"+fileName));
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

	public void deleteLog(Vector<VLecture> selectedRow) {
		// TODO Auto-generated method stub
		
	}
}
