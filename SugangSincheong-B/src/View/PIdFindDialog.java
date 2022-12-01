package View;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Service.SLogin;
import ValueObject.VAccount;

public class PIdFindDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JPanel idPanel;
	private JLabel lbName;
	private JTextField tfName;
	private JPanel studentCodePanel;
	private JPasswordField tfStudentCode;
	private JLabel lbStudentCode;
	private JPanel buttonPanel;
	private JButton btConfirm;
	private SLogin sLogin;
	
	VAccount vAccount;
	
	private ActionHandler action;
	
	public PIdFindDialog () {
		this.setSize(210,300);
		this.setTitle("아이디 찾기"); 
		this.setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
		this.action = new ActionHandler();
		
		idPanel = new JPanel();
		this.add(idPanel);
		
		lbName = new JLabel("이름: ");
		idPanel.add(lbName);
	
		this.tfName = new JTextField();
		this.tfName.setColumns(10);
		idPanel.add(this.tfName); 
		
		studentCodePanel = new JPanel();
		this.add(studentCodePanel);
		
		lbStudentCode = new JLabel("학번: ");
		studentCodePanel.add(lbStudentCode);
		
		this.tfStudentCode = new JPasswordField();
		this.tfStudentCode.setColumns(10);
		studentCodePanel.add(this.tfStudentCode);
		
		//로그인 버튼 
		buttonPanel = new JPanel();
		this.add(buttonPanel);
		
		btConfirm = new JButton("확인");
		btConfirm.addActionListener(this.action);
		System.out.println("ㅇ" + action);
		buttonPanel.add(btConfirm);
		
		this.sLogin = new SLogin();
		char[] a = tfStudentCode.getPassword();
	}
	
//	private void findId() {
//		System.out.println("눌렸니?");
//		if(tfName.getText() != null && tfStudentCode.getPassword() != null) {
//			System.out.println("아이디 찾고 싶어요..");
//		}
//	}
//	
	private static int parseInt (char[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			int value = Integer.parseInt(String.valueOf(a[i]));
			temp = temp * 10 + value;
		}
		System.out.println("temp:" + temp);
		return temp;
	}
	
	private VAccount findId() {
		
		System.out.println("눌렸니?");
		if(lbName.getText() != null &&  tfStudentCode.getPassword() != null) {
			int newStudentCode = parseInt(tfStudentCode.getPassword());

			VAccount vAccount = sLogin.findId(lbName.getText() , newStudentCode);
			
			System.out.println("비번 찾고 싶어요..");
			System.out.println("아이디정보: " + vAccount.getId());
		}

		return vAccount;
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			findId();
			}
		}
}
