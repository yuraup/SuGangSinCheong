
package View;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Service.SLogin;
import ValueObject.VAccount;

public class PLoginDialog extends JDialog {

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
	
	public PLoginDialog(Frame parent) {
		super(parent, "로그인", false); //modal
		this.setSize(400,150);
		setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
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
		
		VAccount vAccount = sLogin.login(id, newPw);
		
		if (vAccount == null) { //로그인 안 될 때 
			JOptionPane.showMessageDialog(null,"로그인에 실패했습니다. " );

		} else  { //로그인 될 때
			if (vAccount.getId().compareTo(id) == 0) {
				PMainFrame pMainFrame = (PMainFrame)this.getParent();
				pMainFrame.setVLogin(vAccount);
				this.dispose();
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