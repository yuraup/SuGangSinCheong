package View;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PPwFindDialog  extends JDialog {
	private static final long serialVersionUID = 1L;
	
	JPanel idPanel;
	JLabel lbId;
	JTextField tfId;
	JPanel studentCodePanel;
	JPasswordField tfStudentCode;
	JLabel lbStudentCode;
	JPanel buttonPanel;
	JButton btConfirm;

	public PPwFindDialog () {
		this.setSize(210,300);
		this.setTitle("비밀번호 찾기"); 
		setLocationRelativeTo(null);
		
		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);
		this.setModal(rootPaneCheckingEnabled);
		
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
		buttonPanel.add(btConfirm);
	}
}
