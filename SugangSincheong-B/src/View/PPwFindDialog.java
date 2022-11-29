package View;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PPwFindDialog  extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JPanel idPanel;
	private JLabel lbId;
	private JTextField tfId;
	private JPanel studentCodePanel;
	private JPasswordField tfStudentCode;
	private JLabel lbStudentCode;
	private JPanel buttonPanel;
	private JButton btConfirm;
	private ActionHandler action;

	public PPwFindDialog () {
		this.setSize(210,300);
		this.setTitle("비밀번호 찾기"); 
		setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
		this.action = new ActionHandler();
		
		idPanel = new JPanel();
		this.add(idPanel);
		
		lbId = new JLabel("아이디: ");
		idPanel.add(lbId);
	
		this.tfId = new JTextField();
		this.tfId.setColumns(10);
		idPanel.add(this.tfId); 
		
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
	
	private void findId() {
		System.out.println("눌렸니?");
		if(lbId.getText() != null && tfStudentCode.getPassword() != null) {
			System.out.println("비번 찾고 싶어요..");
		}
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			findId();
			}
		}
	
}
