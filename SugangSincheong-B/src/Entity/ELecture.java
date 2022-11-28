package Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VLecture;

public class ELecture {
	public Vector<VLecture> getLectures(String fileName) {
		Vector<VLecture> vLectures = new Vector<VLecture>();
		try {
			Scanner scanner = new Scanner(new File("directory/"+fileName));
			while (scanner.hasNext()) {
				VLecture vLecture = new VLecture(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5")));
				vLecture.read(scanner);
				vLectures.add(vLecture);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vLectures;
	}
}
