package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ValueObject.VAccount;
import View.Account.PLoginDialog;

public class Main {
	PLoginDialog loginDialog;
	PMainFrame mainFrame;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
	}
	
	public Main () {
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new PLoginDialog(actionHandler);
	}
	
	private void initialize() { //초기화 
		this.loginDialog.setVisible(true);
	}
	
	private void run(VAccount account) { //실행 
		this.mainFrame = new PMainFrame(account);
		mainFrame.setTitle("수강신청 프로그램 ");
		mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
		
	}
	
	private void finish() { //종료 
		System.exit(0);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료 클릭시 터미널도 종료 
	}
	
	public class ActionHandler implements ActionListener {
		int loginCount = 0; //로그인 시도 횟수
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VAccount account = loginDialog.login(); //로그인 - 회원정보 
			
			if (account != null) { //회원 정보가 맞다면 (id, pw) 
				run(account);
				loginDialog.dispose();
			} else { //회원 정보가 틀리다면 
				loginCount = loginCount + 1;
				JOptionPane.showMessageDialog(null, "로그인 실패" + loginCount +"회입니다.", "로그인 경고  ", JOptionPane.INFORMATION_MESSAGE);
				if (loginCount >= 3) { //로그인을 3번 틀리면 강제 종료 
					JOptionPane.showMessageDialog(null, "3회 이상 로그인에 실패했습니다. 프로그램을 다시 실행해주세요. ", "로그인 실패 : 접속 차단 ", JOptionPane.INFORMATION_MESSAGE);
					finish();	
				}
			}
		}		
	}
}