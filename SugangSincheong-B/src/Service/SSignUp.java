package Service;

import Entity.EAccount;
import ValueObject.VAccount;

public class SSignUp {
	
	private EAccount eAccount;
	public SSignUp () {
		this.eAccount = new EAccount();
	}
	
	//회원가입 dialog의 아이디 검증 
	public boolean check(VAccount vAccount) {
		boolean found = false;
		if(this.eAccount.checkId(vAccount.getId()) == true)  { //이미 아이디가 있다면
			found = true;
			return found;
		} //아이디를 새로 만들어도 된다면  
			return found;
	}
	
	//회원가입 요청시 modal에 파일 작성 요청
	public void signUp(VAccount vAccount) {
		this.eAccount.signUp(vAccount);
		
	}

}
