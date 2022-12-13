package ValueObject;
import java.util.Scanner;

public class VDirectory { //디렉토리 타입 
	private String id;
	private	String name;
	private String fileName;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFileName() {
		return fileName;
	}
	public void read(Scanner scanner) { //스캐너로 읽은 정보를 vDirectory에 저장한다. 
		this.id = scanner.next();
		this.name = scanner.next();
		this.fileName = scanner.next();
	}
}
