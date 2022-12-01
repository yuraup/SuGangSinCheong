package View;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Service.SLogin;
import ValueObject.VAccount;

public class PPwFindDialog  extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JPanel idPanel;
	private JLabel lbId;
	private JTextField tfId;
	private JPanel studentCodePanel;
	private JPasswordField tfStudentCode;
	private JLabel lbStudentCode;
	private JPanel buttonPanel;
	private JButton btConfirm;
	private ActionHandler action;
	private SLogin sLogin;
	VAccount vAccount;

	public PPwFindDialog () {
		this.setSize(210,300);
		this.setTitle("비밀번호 찾기"); 
		setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
		this.action = new ActionHandler();
		
		idPanel = new JPanel();
		this.add(idPanel);
		
		lbId = new JLabel("아이디: ");
		idPanel.add(lbId);
	
		this.tfId = new JTextField();
		this.tfId.setColumns(10);
		idPanel.add(this.tfId); 
		
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
		buttonPanel.add(btConfirm);
		this.sLogin = new SLogin();
	}
	
	private static int parseInt (char[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			int value = Integer.parseInt(String.valueOf(a[i]));
			temp = temp * 10 + value;
		}
		System.out.println("temp:" + temp);
		return temp;
	}
	
	private VAccount findPw() {
		System.out.println("패스워드 눌렸니?");
		if(tfId.getText() != null &&  tfStudentCode.getPassword() != null) {
			int newStudentCode = parseInt(tfStudentCode.getPassword());

			VAccount vAccount = sLogin.findPw(tfId.getText() , newStudentCode);
			
			System.out.println("비번 찾고 싶어요..");
			JOptionPane.showMessageDialog(null, "비밀번호: " + vAccount.getPassword(), "비밀번호를 찾았습니다.", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("비밀번호 정보: " + vAccount.getPassword());
		}
		return vAccount;
	}
	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			findPw();
			}
		}
	
}
