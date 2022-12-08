package View;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Service.SSignUp;
import ValueObject.VAccount;

public class PSignUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel lbId;
	private JTextField tfId;
	private JLabel lbPw;
	private JPasswordField tfPw;
	private JPasswordField tfRePw;
	private JLabel lbName;
	private JTextField tfName;
	private JLabel lbGrade;
	private JTextField tfGrade;
	private JLabel lbDepartment;
	private JTextField tfDepartment;
	private JTextField tfStudentCode;
	private JLabel lbStudentCode;
	private JButton btConfirm;
	
	private SSignUp sSignUp;
	
	private ActionHandler action;
	
	private boolean idCheck = false;
	private boolean pwCheck = false;
	
	String pw = "";
	String pwRe = "";
	
	VAccount vAccount;
	
	LayoutManager layoutManager = new GridBagLayout();
	
	public PSignUpDialog () {
		this.setSize(450, 550);
		this.setTitle("회원가입");
		setLocationRelativeTo(null);
	
		
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled); //모달
		
		this.action = new ActionHandler();
		
			// id UI
			lbId = new JLabel("아이디: ");
			gridsert(this.lbId, 0, 0, 1, 1); // x y w h 
			
			this.tfId = new JTextField();
			gridsert(this.tfId, 1, 0, 2, 1); 
				
			btConfirm = new JButton("중복 확인");
			btConfirm.addActionListener(this.action);
			gridsert(this.btConfirm, 2, 0, 1, 1); 
		
			// pw  UI
			lbPw = new JLabel("비밀번호: ");
			gridsert(this.lbPw, 0, 1, 1, 1); 
			this.tfPw = new JPasswordField();
			gridsert(this.tfPw, 1, 1, 2, 1); 
					
			lbPw = new JLabel("비밀번호 확인: ");
			gridsert(this.lbPw, 0, 2, 1, 1); 
			
			this.tfRePw = new JPasswordField();
			gridsert(this.tfRePw, 1, 2, 2, 1); 

			btConfirm = new JButton("비밀번호 확인");
			btConfirm.addActionListener(this.action);
			gridsert(this.btConfirm, 3, 2, 1, 1);
					
			//이름 UI
			lbName = new JLabel("이름: ");
			gridsert(this.lbName, 0, 3, 1, 1); 
			this.tfName = new JTextField();
			gridsert(this.tfName, 1, 3, 2, 1);
					
			//학년 UI
			lbGrade = new JLabel("학년(숫자만): ");
			gridsert(this.lbGrade, 0, 4, 1, 1); 
			this.tfGrade = new JTextField();
			gridsert(this.tfGrade, 1, 4, 2, 1); 	
					
			//학과 UI
			lbDepartment = new JLabel("학과(~학과): ");
			gridsert(this.lbDepartment, 0, 5, 2, 1); 
			this.tfDepartment = new JTextField();
			gridsert(this.tfDepartment, 1, 5, 2, 1); 
					
			//학번 UI
			lbStudentCode = new JLabel("학번: ");
			gridsert(this.lbStudentCode, 0, 6, 1, 1); 
			this.tfStudentCode = new JTextField();
			gridsert(this.tfStudentCode, 1, 6, 2, 1); 
			
			//회원가입 버튼 
			btConfirm = new JButton("가입");
			btConfirm.addActionListener(this.action);
			gridsert(this.btConfirm, 0, 7, 3, 1); 
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
				if (idCheck != true && pwCheck != true && tfId.getText() !=null && tfPw.getPassword() !=null
						&& tfName.getText() != null && tfGrade.getText() !=null	&& tfDepartment.getText() !=null
						&& tfStudentCode.getText() != null 
					) {
					createAccount();					
				}

			} 
		}
	}
	
	public void gridsert(Component c, int x, int y, int w, int h) { //GridBagLayout 
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill= GridBagConstraints.BOTH;
		
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		gridBagConstraints.gridwidth = w;
		gridBagConstraints.gridheight = h;
		
		((GridBagLayout) layoutManager).setConstraints(c, gridBagConstraints);
		this.add(c);
        
	}
	
}
