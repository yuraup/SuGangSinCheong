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

	public VAccount getLogin(String id, String name) {
		VAccount vAccount = null;
		//		VAccount vAccount = ;
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
				vAccount = new VAccount(this.id, this.password, this.name);
//				vAccount.setId(this.id);
//				vAccount.setPassword(this.password);
//				vAccount.setName(this.name);

			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return vAccount;
	}

}
