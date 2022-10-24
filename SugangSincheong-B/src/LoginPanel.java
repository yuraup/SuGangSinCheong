
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private EAccount eAccount;
	
	private static final long serialVersionUID = 1L;

	private JTextField tfId;
	private JPasswordField tfPassword;
	private JLabel lbPassword ;
	private JLabel lbTitle;
	private SLogin sLogin;
	private JLabel lbId;
	private JButton btLogin;
	
	private String changePasswordType(char[] password) { //g
		String GoodPassword = "";
		for (char cha : password) {         
	         Character.toString(cha);       // cha에 저장된 값 string으로 변환
	       // pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장 삼항연산자
	         GoodPassword += (GoodPassword.equals("")) ? ""+cha+"" : ""+cha+"";   
	     }
		return GoodPassword;
	}
	
	public LoginPanel() {
		LayoutManager layoutManager = new GridLayout(3, 2);
		this.setLayout(layoutManager);
		
		//아이디 
		lbId = new JLabel("아이디: ");
		this.add(lbId);
	
		
		this.tfId = new JTextField();
		this.tfId.setColumns(10);
		this.add(this.tfId);
		
		//비밀번호 
		lbPassword = new JLabel("비밀번호: ");
		this.add(lbPassword);
		
		this.tfPassword = new JPasswordField();
		this.tfPassword.setColumns(10);
		this.add(this.tfPassword);
		
		//로그인 버튼 
		btLogin = new JButton("로그인");
		this.add(btLogin);
		
		ActionHandler actionHandler = new ActionHandler();
		btLogin.addActionListener(actionHandler);
		
//		SuccessPanel successPanel = new SuccessPanel();
//		this.add(successPanel);
		this.sLogin = new SLogin();
	}
	
	private void login() {
		String id = this.tfId.getText();
		char[] password =  this.tfPassword.getPassword();
		String newPw = 	changePasswordType(password);
		
		VLogin vLogin = sLogin.login(id, newPw);
		
		if (vLogin == null) { //로그인 안 될 때 
			JOptionPane.showMessageDialog(null,"로그인에 실패했습니다. " );
			JLabel text = new JLabel("dd" );
		} else  { //로그인 될 때
			if (vLogin.getId().compareTo(id) == 0) {
				if(newPw != null && newPw.compareTo(vLogin.getPassword()) == 0) {
					JOptionPane.showMessageDialog(null,"환영합니다 ~  " + vLogin.getName() + "님");
					System.out.println("로그인에 성공했습니다." );
				}
				else 
					JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요." );
			} 
	
		} 

	}
	

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			login(); //로그인 함수 호출 
		}		
	}
}

