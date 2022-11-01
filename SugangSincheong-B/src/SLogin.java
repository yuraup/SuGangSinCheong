
public class SLogin {
	
	private EAccount eAccount;
	public SLogin() {
		this.eAccount = new EAccount();
	}

	public VAccount login(String id, String password) {
		VAccount vAccount = this.eAccount.getLogin(id, password);
		
		return vAccount;
	}

}
