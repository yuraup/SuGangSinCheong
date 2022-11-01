
public class VAccount { //코드의 효율성을 위해서 
	private String id;
	private String password;
	private String name;
	
	public VAccount(String id, String pw, String name) {
		this.id = id;
		this.password = pw;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void hello() {
		
	}

}
