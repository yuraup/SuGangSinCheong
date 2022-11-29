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

public class PIdFindDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JPanel idPanel;
	private JLabel lbName;
	private JTextField tfName;
	private JPanel studentCodePanel;
	private JPasswordField tfStudentCode;
	private JLabel lbStudentCode;
	private JPanel buttonPanel;
	private JButton btConfirm;
	
	private ActionHandler action;
	
	public PIdFindDialog () {
		this.setSize(210,300);
		this.setTitle("아이디 찾기"); 
		this.setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
		this.action = new ActionHandler();
		
		idPanel = new JPanel();
		this.add(idPanel);
		
		lbName = new JLabel("이름: ");
		idPanel.add(lbName);
	
		this.tfName = new JTextField();
		this.tfName.setColumns(10);
		idPanel.add(this.tfName); 
		
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
		System.out.println("ㅇ" + action);
		buttonPanel.add(btConfirm);
		
		
	}
	
	private void findId() {
		System.out.println("눌렸니?");
		if(tfName.getText() != null && tfStudentCode.getPassword() != null) {
			System.out.println("아이디 찾고 싶어요..");
		}
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			findId();
			}
		}
}
