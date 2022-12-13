package Service;
import java.util.Vector;

import Entity.EDirectory;
import ValueObject.VDirectory;

public class SDirectory {
	private EDirectory eDirectory;
	public SDirectory() {
		this.eDirectory = new EDirectory();
	}

	public Vector<VDirectory> getDirectories(String fileName) { //fileName을 전달한다. 
		return this.eDirectory.getDirectories(fileName);
	}
}
