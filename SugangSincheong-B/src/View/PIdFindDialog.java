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
		this.setModal(rootPaneCheckingEnabled); //모달 
		
		//확인 버튼 이벤트 핸들러 
		this.action = new ActionHandler();
		
		idPanel = new JPanel(); // id UI 
		this.add(idPanel);
		
			lbName = new JLabel("이름: ");
			idPanel.add(lbName);
		
			this.tfName = new JTextField();
			this.tfName.setColumns(10);
			idPanel.add(this.tfName); 
		
		studentCodePanel = new JPanel(); //학번 UI 
		this.add(studentCodePanel);
		
			lbStudentCode = new JLabel("학번: ");
			studentCodePanel.add(lbStudentCode);
			
			this.tfStudentCode = new JPasswordField();
			this.tfStudentCode.setColumns(10);
			studentCodePanel.add(this.tfStudentCode);
		
		//로그인 버튼 
		buttonPanel = new JPanel(); //확인 버튼 UI 
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
	
	private VAccount findId() { // input 입력 완료시 아이디 검색 
		if(tfName.getText() != null &&  tfStudentCode.getPassword() != null) {
			int newStudentCode = parseInt(tfStudentCode.getPassword());

			VAccount vAccount = sLogin.findId(tfName.getText() , newStudentCode);
			JOptionPane.showMessageDialog(null, "아이디: " + vAccount.getId(), "아이디를 찾았습니다.", JOptionPane.INFORMATION_MESSAGE);
		}
		return vAccount;
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			findId(); // 확인 버튼 클릭시 해당 함수 실행 
			}
		}
}
