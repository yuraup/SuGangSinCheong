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

public class PSignUpDialog extends JDialog{
	private static final long serialVersionUID = 1L;

	private JPanel idPanel;
	private JLabel lbId;
	private JTextField tfId;
	private JPanel pwPanel;
	private JLabel lbPw;
	private JTextField tfPw;
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
	private JPasswordField tfStudentCode;
	private JLabel lbStudentCode;
	private JPanel buttonPanel;
	private JButton btConfirm;
	
	private ActionHandler action;
	
//	private SLogin sLogin;
	VAccount vAccount;
	
	public PSignUpDialog () {
		this.setSize(260, 400);
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
					
				// pw  UI
				pwPanel = new JPanel(); 
				this.add(pwPanel);
					
					lbPw = new JLabel("비밀번호: ");
					pwPanel.add(lbPw);
					this.tfPw = new JTextField();
					this.tfPw.setColumns(10);
					pwPanel.add(this.tfPw); 
					
				//이름 UI
				namePanel = new JPanel(); 
				this.add(namePanel);
				
					lbName = new JLabel("이름: ");
					namePanel.add(lbName);
					this.tfName = new JPasswordField();
					this.tfName.setColumns(10);
					namePanel.add(this.tfName);			
				//학년 UI
				gradePanel = new JPanel(); 
				this.add(gradePanel);
					
					lbGrade = new JLabel("학년(숫자만): ");
					gradePanel.add(lbGrade);
					this.tfGrade = new JPasswordField();
					this.tfGrade.setColumns(10);
					gradePanel.add(this.tfGrade);
					
					//학과 UI
				departmentPanel = new JPanel(); 
				this.add(departmentPanel);
						
					lbDepartment = new JLabel("학과(~학과): ");
					departmentPanel.add(lbDepartment);
					this.tfDepartment = new JPasswordField();
					this.tfDepartment.setColumns(10);
					departmentPanel.add(this.tfDepartment);	
					
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
	}

	private VAccount createAccount() { // 확인 버튼 클릭시 회원가입 진행 
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다. " + vAccount.getPassword(), "회원가입", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		return vAccount;
	}
	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			createAccount();
			}
		}
}
