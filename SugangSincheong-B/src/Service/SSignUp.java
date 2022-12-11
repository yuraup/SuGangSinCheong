package Service;

import Entity.EAccount;
import ValueObject.VAccount;

public class SSignUp {
	
	private EAccount eAccount;
	
	public SSignUp () {
		this.eAccount = new EAccount();
	}
	

	public boolean check(VAccount vAccount) { //회원가입 dialog의 아이디 검증 
		boolean found = true;
		
		if(this.eAccount.checkId(vAccount.getId()) == true)  { //이미 아이디가 있다면
			found = false;
			return found; //false
		} //아이디를 새로 만들어도 된다면  
			return found; //true
	}
	
	//회원가입 요청시 modal에 파일 작성 요청
	public void signUp(VAccount vAccount) { //회원가입 
		this.eAccount.signUp(vAccount);
		
	}
}
