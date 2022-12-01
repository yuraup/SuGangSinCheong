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
		this.setModal(rootPaneCheckingEnabled); //모달
		
		//확인 버튼 이벤트 핸들러 
		this.action = new ActionHandler();
		
		// id UI
		idPanel = new JPanel(); 
		this.add(idPanel);
		
			lbId = new JLabel("아이디: ");
			idPanel.add(lbId);
		
			this.tfId = new JTextField();
			this.tfId.setColumns(10);
			idPanel.add(this.tfId); 
		
		//학번 UI
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
	
	private static int parseInt (char[] beforeStudentCode) {  // char[] 타입을 int로 변환 
		int afterStudentCode = 0;
		for (int i = 0; i < beforeStudentCode.length; i++) {
			int value = Integer.parseInt(String.valueOf(beforeStudentCode[i]));
			afterStudentCode = afterStudentCode * 10 + value;
		}
		return afterStudentCode;
	}
	
	private VAccount findPw() { // id와 학번 입력시 비밀번호 찾기 기능 수행 
		if(tfId.getText() != null &&  tfStudentCode.getPassword() != null) {
			int newStudentCode = parseInt(tfStudentCode.getPassword());
			VAccount vAccount = sLogin.findPw(tfId.getText() , newStudentCode);
			JOptionPane.showMessageDialog(null, "비밀번호: " + vAccount.getPassword(), "비밀번호를 찾았습니다.", JOptionPane.INFORMATION_MESSAGE);
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
