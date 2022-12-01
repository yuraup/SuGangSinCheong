
package View;

import java.awt.FlowLayout;
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
	PAccountPanel pAccountPanel;
	VAccount vAccount;
	
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
//		super(parent, "로그인", false); //modal
		this.setSize(290,300);
		setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
		topPanel = new JPanel();
		this.add(topPanel);
		middleUpPanel = new JPanel();
		this.add(middleUpPanel);
		middleDownPanel = new JPanel();
		this.add(middleDownPanel);
		bottomPanel = new JPanel();
		this.add(bottomPanel);
		
		//아이디 
		idPanel = new JPanel();
		topPanel.add(idPanel);
		
		lbId = new JLabel("아이디: ");
		idPanel.add(lbId);
	
		this.tfId = new JTextField();
		this.tfId.setColumns(10);
		idPanel.add(this.tfId); 
		
		//비밀번호 
		pwPanel = new JPanel();
		middleUpPanel.add(pwPanel);
		
		lbPassword = new JLabel("비밀번호: ");
		pwPanel.add(lbPassword);
		
		this.tfPassword = new JPasswordField();
		this.tfPassword.setColumns(10);
		pwPanel.add(this.tfPassword);
		
		//로그인 버튼 
		buttonPanel = new JPanel();
		middleDownPanel.add(buttonPanel);
		
		btLogin = new JButton("로그인");
		this.getRootPane().setDefaultButton(btLogin); //엔터시 로그인 되도록 default 추가
		buttonPanel.add(btLogin);
		
		JLabel line = new JLabel("--------------------------------");
		bottomPanel.add(line);
		
		bottomPanel = new JPanel();
		this.add(bottomPanel);
		btFindId = new JButton("아이디찾기");
		btFindId.addActionListener(this);
		bottomPanel.add(btFindId);
		btFindPw = new JButton("비밀번호찾기");
		btFindPw.addActionListener(this);
		bottomPanel.add(btFindPw);
		
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
//			pSignUpDialog.setVisible(true);
		}
	}
}
