package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ValueObject.VAccount;

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
	
	private void initialize() {
		this.loginDialog.setVisible(true);
	}
	
	private void run(VAccount account) { //실행 
		this.mainFrame = new PMainFrame(account);
		mainFrame.setTitle("수강신청 프로그램 ");
		mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
		
	}
	
	private void finish() {
		System.exit(0);
	}
	
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			VAccount account = loginDialog.login();
			if (account != null) {
				run(account);
				loginDialog.dispose();
			} else {
				System.out.println("로그인 실패 " + account);
				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다. 프로그램을 다시 실행해주세요. ", "로그인 실패 : 접속 차단 ", JOptionPane.INFORMATION_MESSAGE);
				finish();
			}
			
		}		
	}
	
}