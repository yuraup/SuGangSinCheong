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
import Service.SSignUp;
import ValueObject.VAccount;

public class PSignUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JPanel idPanel;
	private JLabel lbId;
	private JTextField tfId;
	private JPanel pwPanel;
	private JLabel lbPw;
	private JPasswordField tfPw;
	private JPasswordField tfRePw;
	private JPanel namePanel;
	private JLabel lbName;
	private JTextField tfName;
	private JPanel gradePanel;
	private JLabel lbGrade;
	private JTextField tfGrade;
	private JPanel departmentPanel;
	private JLabel lbDepartment;
	private JTextField tfDepartment;
	private JPanel studentCodePanel;
	private JTextField tfStudentCode;
	private JLabel lbStudentCode;
	private JPanel buttonPanel;
	private JButton btConfirm;
	
	private SSignUp sSignUp;
	
	private ActionHandler action;
	
	private boolean idCheck = false;
	private boolean pwCheck = false;
	
	String pw = "";
	String pwRe = "";
	
	VAccount vAccount;
	
	public PSignUpDialog () {
		this.setSize(350, 400);
		this.setTitle("회원가입");
		setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled); //모달
		
		this.action = new ActionHandler();
		
			// id UI
			idPanel = new JPanel(); 
			this.add(idPanel);
				
				lbId = new JLabel("아이디: ");
				idPanel.add(lbId);
				this.tfId = new JTextField();
				this.tfId.setColumns(10);
				idPanel.add(this.tfId); 
					
				btConfirm = new JButton("중복 확인");
				btConfirm.addActionListener(this.action);
				idPanel.add(btConfirm);
			
				// pw  UI
			pwPanel = new JPanel(); 
			this.add(pwPanel);
					
				lbPw = new JLabel("비밀번호: ");
				pwPanel.add(lbPw);
				this.tfPw = new JPasswordField();
				this.tfPw.setColumns(10);
				pwPanel.add(this.tfPw); 
					
				pwPanel = new JPanel(); 
				this.add(pwPanel);
						
				lbPw = new JLabel("비밀번호 재확인: ");
				pwPanel.add(lbPw);
				this.tfRePw = new JPasswordField();
				this.tfRePw.setColumns(10);
				pwPanel.add(this.tfRePw); 
					
				btConfirm = new JButton("비밀번호 확인");
				btConfirm.addActionListener(this.action);
				pwPanel.add(btConfirm);
					
				//이름 UI
				namePanel = new JPanel(); 
				this.add(namePanel);
				
					lbName = new JLabel("이름: ");
					namePanel.add(lbName);
					this.tfName = new JTextField();
					this.tfName.setColumns(10);
					namePanel.add(this.tfName);			
					
				//학년 UI
				gradePanel = new JPanel(); 
				this.add(gradePanel);
					
					lbGrade = new JLabel("학년(숫자만): ");
					gradePanel.add(lbGrade);
					this.tfGrade = new JTextField();
					this.tfGrade.setColumns(10);
					gradePanel.add(this.tfGrade);
					
				//학과 UI
				departmentPanel = new JPanel(); 
				this.add(departmentPanel);
						
					lbDepartment = new JLabel("학과(~학과): ");
					departmentPanel.add(lbDepartment);
					this.tfDepartment = new JTextField();
					this.tfDepartment.setColumns(10);
					departmentPanel.add(this.tfDepartment);	
					
				//학번 UI
				studentCodePanel = new JPanel(); 
				this.add(studentCodePanel);
				
					lbStudentCode = new JLabel("학번: ");
					studentCodePanel.add(lbStudentCode);
					this.tfStudentCode = new JTextField();
					this.tfStudentCode.setColumns(10);
					studentCodePanel.add(this.tfStudentCode);
				
				//회원가입 버튼 
				buttonPanel = new JPanel(); 
				this.add(buttonPanel);
				
					btConfirm = new JButton("가입");
					btConfirm.addActionListener(this.action);
					buttonPanel.add(btConfirm);
	}
	
	private void idOverlapCheck() {
		VAccount vAccount = new VAccount();
		sSignUp = new SSignUp();
		vAccount.setId(tfId.getText());
		
		if (sSignUp.check(vAccount)) {
			JOptionPane.showMessageDialog(null, "이미 아이디가 존재합니다.");
			idCheck = true;
		} else {
			JOptionPane.showMessageDialog(null, "가입 가능한 아이디입니다.");
			idCheck = false;
		}
	}
	
	private void pwDoubleCheck () {
		for (int i = 0; i < tfPw.getPassword().length; i++ ) {
			pw += tfPw.getPassword()[i];
		}
		for (int j = 0; j < tfRePw.getPassword().length; j++) {
			pwRe += tfRePw.getPassword()[j]; 
		}
		if (pw.equals(pwRe)) {
			JOptionPane.showMessageDialog(null, "확인되었습니다.");
			pwCheck = false;
			
		} 
		else {
			pwCheck = true;
			JOptionPane.showMessageDialog(null, "비밀번호 확인이 일치하지 않습니다.");	
		} 
	}

	private VAccount createAccount() { // 확인 버튼 클릭시 회원가입 진행 
			VAccount vAccount = new VAccount();
			sSignUp = new SSignUp();
			
			vAccount.setId(tfId.getText());
			vAccount.setPassword(pw);
			vAccount.setName(tfName.getText());
			vAccount.setGrade(tfGrade.getText());
			vAccount.setDepartment(tfDepartment.getText());
			vAccount.setStudentCode(Integer.parseInt(tfStudentCode.getText()));
			
			sSignUp.signUp(vAccount);
			
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다. ", "회원가입", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		return vAccount;
	}
	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonRoute = e.getActionCommand();
			if (buttonRoute == "중복 확인") {
				idOverlapCheck();
			} else if (buttonRoute == "비밀번호 확인") {
				pwDoubleCheck();
			} else if (buttonRoute == "가입") {
				if (idCheck == false && pwCheck == false) {
					createAccount();					
				}

			} 
		}
	}
	

}
