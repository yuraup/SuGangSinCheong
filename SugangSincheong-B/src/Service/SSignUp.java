package Service;

import Entity.EAccount;
import ValueObject.VAccount;

public class SSignUp {
	
	private EAccount eAccount;
	
	public SSignUp () {
		this.eAccount = new EAccount();
	}

	public boolean check(VAccount vAccount) { //회원가입 아이디 중복 체크 
		boolean found = true;
		
		if (this.eAccount.checkId(vAccount.getId()) == true) { 
		  //이미 아이디가 있다면
			found = false;
			return found; //false
		} //아이디를 새로 만들어도 된다면  
			return found; //true
	}
	
	//회원가입 기능 (파일에 회원 정보 작성)
	public void signUp(VAccount vAccount) { //회원가입 
		this.eAccount.signUp(vAccount);
	}
}
