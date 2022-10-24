import java.util.Scanner;

public class PLogin {

	private SLogin sLogin;
	public PLogin() {
		this.sLogin = new SLogin();
	}

	public VLogin show() {
		System.out.print("아이디를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		
		System.out.print("아이디를 입력하세요 : ");
		String password = scanner.next();
		scanner.close();
		
		VLogin vLogin = sLogin.login(id, password);
		if (vLogin == null) {
			
		}
		return vLogin;
		
	}

}
