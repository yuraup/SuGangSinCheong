
package View;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Service.SLogin;
import ValueObject.VAccount;
import View.Main.ActionHandler;

public class PLoginDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lbId;
	JTextField tfId;
	JPasswordField tfPassword;
	private JLabel lbPassword;
	private JButton btLogin;
	private SLogin sLogin;
	private JButton btFindId;
	private JButton btFindPw;
	private JButton btSignUp;
	PAccountPanel pAccountPanel;
	VAccount vAccount;
	
	LayoutManager layoutManager = new GridBagLayout();
	
	public PLoginDialog(ActionHandler actionHandler) {
		this.setTitle("수강신청 프로그램");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //프로그램 터미널 종료
		this.setSize(550,400);
		setLocationRelativeTo(null); //중앙 정렬 
		
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
		this.lbId = new JLabel("아이디: ");
		gridsert(this.lbId, 0, 0, 1, 1); // x y w h 
	
		this.tfId = new JTextField();
		gridsert(this.tfId, 1, 0, 1, 1); 

		lbPassword = new JLabel("비밀번호: ");
		gridsert(this.lbPassword, 0, 1, 1, 1); 
		
		this.tfPassword = new JPasswordField();
		gridsert(this.tfPassword, 1, 1, 1, 1); 
		
		this.btLogin = new JButton("로그인");
		this.getRootPane().setDefaultButton(this.btLogin); //엔터시 로그인 되도록 default 추가
		gridsert(this.btLogin, 1, 2, 1, 1); 
		
		JLabel line = new JLabel("--------------------------------");
		gridsert(line, 1, 3, 1, 1);

		btSignUp = new JButton("회원가입");
		btSignUp.addActionListener(this);
		gridsert(btSignUp, 1, 5, 1, 1);

		btFindId = new JButton("아이디찾기");
		btFindId.addActionListener(this);
		gridsert(btFindId, 0, 5, 1, 1); 

		btFindPw = new JButton("비밀번호찾기");
		btFindPw.addActionListener(this);
		gridsert(btFindPw, 2, 5, 1, 1); 
		
		btLogin.addActionListener(actionHandler);
		this.sLogin = new SLogin();
	}
	
	VAccount login() {
		String id = this.tfId.getText();
		char[] password =  this.tfPassword.getPassword();
		String newPw = 	changePasswordType(password);
		VAccount vAccount = sLogin.login(id, newPw);
		
		return vAccount;
	}
	
	String changePasswordType(char[] password) { //char -> String
		String newPw = "";
		for (char cha : password) {         
	         Character.toString(cha);  // cha에 저장된 값 string으로 변환
	       // pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장 (삼항연산자)
	         newPw += (newPw.equals("")) ? ""+cha+"" : ""+cha+"";   
	     }
		
		return newPw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {   //버튼에 따라 액션이 다르도록 설정
		String buttonRoute = e.getActionCommand(); 
		
		if (buttonRoute == "아이디찾기") {
			PIdFindDialog pIdFindDialog = new PIdFindDialog();
			pIdFindDialog.setVisible(true);
			
		} else if (buttonRoute == "비밀번호찾기") {
			PPwFindDialog pPwFindDialog = new PPwFindDialog();
			pPwFindDialog.setVisible(true);
			
		} else if (buttonRoute == "회원가입") {
			PSignUpDialog pSignUpDialog = new PSignUpDialog();
			pSignUpDialog.setVisible(true);
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
