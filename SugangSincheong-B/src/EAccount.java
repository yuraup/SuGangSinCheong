import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EAccount {

	private String id;
	private String password;
	private String name;
	// ...
	
	public EAccount() {
	}

	public VLogin getLogin(String id, String name) {
		VLogin vLogin = null;
		try {
			File file = new File("data/account");
			Scanner scanner = new Scanner(file);
			// file read
			boolean found = false;
			while (scanner.hasNext() && !found) {
				this.id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				
				
				if (this.id.compareTo(id) == 0) {
					if(this.password.compareTo(password) == 0) {
					found = true;
					}
				}
			}
			scanner.close();
			
			if (found) {
				vLogin = new VLogin();
				vLogin.setId(this.id);
				vLogin.setPassword(this.password);
				vLogin.setName(this.name);

			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return vLogin;
	}

}
