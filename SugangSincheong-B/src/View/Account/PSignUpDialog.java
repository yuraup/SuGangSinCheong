package View.Account;

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
	
	private boolean idCheck = true;
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
			
			this.tfId = new JTextField(10);
			gridsert(this.tfId, 1, 0, 1, 1); 
				
			btConfirm = new JButton("중복 확인");
			btConfirm.addActionListener(this.action);
			gridsert(this.btConfirm, 3, 0, 1, 1); 
		
			// pw  UI
			lbPw = new JLabel("비밀번호: ");
			gridsert(this.lbPw, 0, 1, 1, 1); 
			this.tfPw = new JPasswordField(10);
			gridsert(this.tfPw, 1, 1, 2, 1); 
					
			lbPw = new JLabel("비밀번호 확인: ");
			gridsert(this.lbPw, 0, 2, 1, 1); 
			
			this.tfRePw = new JPasswordField(10);
			gridsert(this.tfRePw, 1, 2, 2, 1); 

			btConfirm = new JButton("비밀번호 확인");
			btConfirm.addActionListener(this.action);
			gridsert(this.btConfirm, 3, 2, 1, 1);
					
			//이름 UI
			lbName = new JLabel("이름: ");
			gridsert(this.lbName, 0, 3, 1, 1); 
			this.tfName = new JTextField(10);
			gridsert(this.tfName, 1, 3, 2, 1);
					
			//학년 UI
			lbGrade = new JLabel("학년(숫자만): ");
			gridsert(this.lbGrade, 0, 4, 1, 1); 
			this.tfGrade = new JTextField(10);
			gridsert(this.tfGrade, 1, 4, 2, 1); 	
					
			//학과 UI
			lbDepartment = new JLabel("학과(~학과): ");
			gridsert(this.lbDepartment, 0, 5, 2, 1); 
			this.tfDepartment = new JTextField(10);
			gridsert(this.tfDepartment, 1, 5, 2, 1); 
					
			//학번 UI
			lbStudentCode = new JLabel("학번: ");
			gridsert(this.lbStudentCode, 0, 6, 1, 1); 
			this.tfStudentCode = new JTextField(10);
			gridsert(this.tfStudentCode, 1, 6, 2, 1); 
			
			//회원가입 버튼 
			btConfirm = new JButton("가입");
			btConfirm.addActionListener(this.action);
			gridsert(this.btConfirm, 0, 7, 3, 1); 
	}
	
	private void idOverlapCheck() { //아이디 중복 체크 기능 (파일 읽음)
		VAccount vAccount = new VAccount();
		sSignUp = new SSignUp();
		vAccount.setId(this.tfId.getText());
		if (this.tfId.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
			idCheck = true;
		} else if (sSignUp.check(vAccount) == false) {
			JOptionPane.showMessageDialog(null, "이미 아이디가 존재합니다.");
			idCheck = true;
		} else if (sSignUp.check(vAccount) == true) {
			JOptionPane.showMessageDialog(null, "가입 가능한 아이디입니다.");
			idCheck = false;
		}
	}
	
	private void pwDoubleCheck () { //비밀번호 확인 
		for (int i = 0; i < this.tfPw.getPassword().length; i++ ) {
			this.pw += this.tfPw.getPassword()[i];
		}
		for (int j = 0; j < this.tfRePw.getPassword().length; j++) {
			this.pwRe += this.tfRePw.getPassword()[j]; 
		}
		
		if (this.pw.equals(this.pwRe)) {
			JOptionPane.showMessageDialog(null, "확인되었습니다.");
			pwCheck = true;
			
		}  else if (!this.pw.equals(this.pwRe)) {
			pwCheck = false;
			JOptionPane.showMessageDialog(null, "비밀번호와 확인을 다시 입력해주세요. ");	
		} 
	}

	private VAccount createAccount() { // 확인 버튼 클릭시 회원가입 진행 
			VAccount vAccount = new VAccount();
			sSignUp = new SSignUp();
			
			vAccount.setId(this.tfId.getText());
			vAccount.setPassword(this.pw);
			vAccount.setName(this.tfName.getText());
			vAccount.setGrade(this.tfGrade.getText());
			vAccount.setDepartment(this.tfDepartment.getText());
			vAccount.setStudentCode(Integer.parseInt(this.tfStudentCode.getText()));
			
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
			} else if (buttonRoute == "가입") { //경우의 수를 나눠 회원가입이 이루어지도록 함.
				if (idCheck == false && pwCheck == false) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인이 필요합니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
				} else if (idCheck == true && pwCheck == false && tfName.getText().equals("") || tfGrade.getText().equals("")
						|| tfDepartment.getText().equals("") || tfStudentCode.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디 중복 체크를 해주세요.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
				} else if (idCheck == false && pwCheck == false && tfName.getText().equals("") || tfGrade.getText().equals("")
						|| tfDepartment.getText().equals("") || tfStudentCode.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "회원정보가 모두 입력되지 않았습니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
				} else if (idCheck == false && pwCheck == true && !tfName.getText().equals("") && !tfGrade.getText().equals("")
						&& !tfDepartment.getText().equals("") && !tfStudentCode.getText().equals("")
					) {
					createAccount();					
				} else {
					JOptionPane.showMessageDialog(null, "입력한 값을 다시 한 번 확인해주세요.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
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
