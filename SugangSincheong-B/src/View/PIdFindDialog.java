package View;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PIdFindDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	JPanel idPanel;
	JLabel lbName;
	JTextField tfName;
	JPanel studentCodePanel;
	JPasswordField tfStudentCode;
	JLabel lbStudentCode;
	JPanel buttonPanel;
	JButton btConfirm;
	
	public PIdFindDialog () {
		this.setSize(210,300);
		this.setTitle("아이디 찾기"); 
		setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
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
		buttonPanel.add(btConfirm);
		
		
	}
}
