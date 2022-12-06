
package View;

import java.awt.Component;
import java.awt.FlowLayout;
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
	JPanel topPanel;
	JPanel middleUpPanel;
	JPanel middleDownPanel;
	JPanel bottomPanel;
	
	JPanel idPanel;
	private JLabel lbId;
	JTextField tfId;
	JPanel pwPanel;
	JPasswordField tfPassword;
	private JLabel lbPassword;
	JPanel buttonPanel;
	private JButton btLogin;
	private SLogin sLogin;
	private JButton btFindId;
	private JButton btFindPw;
	private JButton btSignUp;
	PAccountPanel pAccountPanel;
	VAccount vAccount;
	
	LayoutManager layoutManager = new GridBagLayout();
	
	String changePasswordType(char[] password) {
		String newPw = "";
		for (char cha : password) {         
	         Character.toString(cha);       // cha에 저장된 값 string으로 변환
	       // pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장 삼항연산자
	         newPw += (newPw.equals("")) ? ""+cha+"" : ""+cha+"";   
	     }
		return newPw;
	}
	
	public PLoginDialog(ActionHandler actionHandler) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		super(parent, "로그인", false); //modal
		this.setSize(550,450);
		setLocationRelativeTo(null);
		
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		GridBagConstraints gridBagConstraints =  new GridBagConstraints();
		
		this.lbId = new JLabel("아이디: ");
		gridsert(this.lbId, 0, 0, 1, 1);
	
		this.tfId = new JTextField();
		gridsert(this.tfId, 1, 0, 1, 1);

		lbPassword = new JLabel("비밀번호: ");
		gridsert(this.lbPassword, 0, 1, 1, 1);
		
		this.tfPassword = new JPasswordField();
		gridsert(this.tfPassword, 1, 1, 1, 1); // x y w h
		
		this.btLogin = new JButton("로그인");
		this.getRootPane().setDefaultButton(this.btLogin); //엔터시 로그인 되도록 default 추가
		gridsert(this.btLogin, 1, 2, 1, 1); // x y w h
		
		JLabel line = new JLabel("--------------------------------");
		gridsert(line, 1, 3, 1, 1); // x y w h

		btSignUp = new JButton("회원가입");
		btSignUp.addActionListener(this);
		gridsert(btSignUp, 1, 5, 1, 1); // x y w h

		btFindId = new JButton("아이디찾기");
		btFindId.addActionListener(this);
		gridsert(btFindId, 0, 5, 1, 1); // x y w h

		btFindPw = new JButton("비밀번호찾기");
		btFindPw.addActionListener(this);
		gridsert(btFindPw, 2, 5, 1, 1); // x y w h
		
		btLogin.addActionListener(actionHandler);
		this.sLogin = new SLogin();
	}
	
	VAccount login() {
		String id = this.tfId.getText();
		char[] password =  this.tfPassword.getPassword();
		String newPw = 	changePasswordType(password);
		
		VAccount vAccount = sLogin.login(id, newPw);
		System.out.println("login vAccount:" + vAccount);
		return vAccount;
	}
	
	public void gridsert(Component c, int x, int y, int w, int h) {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill= GridBagConstraints.BOTH;
		
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		gridBagConstraints.gridwidth = w;
		gridBagConstraints.gridheight = h;
		
		((GridBagLayout) layoutManager).setConstraints(c, gridBagConstraints);
		this.add(c);
        
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonRoute = e.getActionCommand();
		if (buttonRoute == "아이디찾기") {
			System.out.println("아이디찾기");
			PIdFindDialog pIdFindDialog = new PIdFindDialog();
			pIdFindDialog.setVisible(true);
			
		} else if (buttonRoute == "비밀번호찾기") {
			System.out.println("비밀번호찾기");
			PPwFindDialog pPwFindDialog = new PPwFindDialog();
			pPwFindDialog.setVisible(true);
		} else if (buttonRoute == "회원가입") {
			PSignUpDialog pSignUpDialog = new PSignUpDialog();
			pSignUpDialog.setVisible(true);
		} 
	}
}
