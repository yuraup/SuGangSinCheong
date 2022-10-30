import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginDialog extends JDialog {
	private EAccount eAccount;

	private static final long serialVersionUID = 1L;
	JPanel idPanel;
	private JLabel lbId;
	JTextField tfId;
	JPanel pwPanel;
	JPasswordField tfPassword;
	private JLabel lbPassword;
	JPanel buttonPanel;
	private JButton btLogin;
	private SLogin sLogin;
	
	SugnasincheongPanel sugangsincheongPanel;
	
	String changePasswordType(char[] password) {
		String GoodPassword = "";
		for (char cha : password) {         
	         Character.toString(cha);       // cha에 저장된 값 string으로 변환
	       // pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장 삼항연산자
	         GoodPassword += (GoodPassword.equals("")) ? ""+cha+"" : ""+cha+"";   
	     }
		return GoodPassword;
	}
	
	public LoginDialog(Frame parent, SugnasincheongPanel sugangsincheongPanel) {
		super(parent, "로그인", false); //modal
		this.setSize(400,150);
		this.sugangsincheongPanel = sugangsincheongPanel;
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		
		//아이디 
		idPanel = new JPanel();
		this.add(idPanel);
		
		lbId = new JLabel("아이디: ");
		idPanel.add(lbId);
	
		
		this.tfId = new JTextField();
		this.tfId.setColumns(10);
		idPanel.add(this.tfId); 
		
		//비밀번호 
		pwPanel = new JPanel();
		this.add(pwPanel);
		lbPassword = new JLabel("비밀번호: ");
		pwPanel.add(lbPassword);
		
		this.tfPassword = new JPasswordField();
		this.tfPassword.setColumns(10);
		pwPanel.add(this.tfPassword);
		
		//로그인 버튼 
		buttonPanel = new JPanel();
		this.add(buttonPanel);
		btLogin = new JButton("로그인");
		buttonPanel.add(btLogin);
		
		ActionHandler actionHandler = new ActionHandler();
		btLogin.addActionListener(actionHandler);
		
		this.sLogin = new SLogin();
	}
	
	private void login() {
		String id = this.tfId.getText();
		char[] password =  this.tfPassword.getPassword();
		String newPw = 	changePasswordType(password);
		
		VLogin vLogin = sLogin.login(id, newPw);
		
		if (vLogin == null) { //로그인 안 될 때 
			JOptionPane.showMessageDialog(null,"로그인에 실패했습니다. " );

		} else  { //로그인 될 때
			if (vLogin.getId().compareTo(id) == 0) {
				if(newPw != null && newPw.compareTo(vLogin.getPassword()) == 0) {
					JOptionPane.showMessageDialog(null,"로그인에 성공했습니다. " + vLogin.getName() + "님!");	
					this.sugangsincheongPanel.hello(vLogin);
					this.setVisible(false);
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

