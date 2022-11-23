package View;

import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ValueObject.VAccount;

public class PMyPage extends JDialog{
	private static final long serialVersionUID = 1L;
	
	public PMyPage(Frame parent, VAccount vAccount) {
		
		super(parent, "마이페이지", false); //modal
		
		this.setSize(400, 200);
		setLocationRelativeTo(null);
		
		JPanel myPanel = new JPanel();
		JPanel subPanel;
		
		JLabel nameTitle = new JLabel("이름: ");
		JLabel nameInfo = new JLabel(vAccount.getName());
		JLabel gradeTitle = new JLabel("학년: ");
		JLabel gradeInfo = new JLabel(vAccount.getGrade());
		JLabel departmentTitle = new JLabel("학과: ");
		JLabel departmentInfo = new JLabel(vAccount.getDepartment());
		
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		this.add(myPanel);
		
		//2
		subPanel = new JPanel();
		subPanel.setSize(100,10);
		myPanel.add(subPanel);
		subPanel.add(nameTitle);
		subPanel.add(nameInfo);

		//3
		subPanel = new JPanel();
		myPanel.add(subPanel);
		subPanel.add(departmentTitle);
		subPanel.add(departmentInfo);
		
		//4
		subPanel  = new JPanel();
		myPanel.add(subPanel);
		subPanel.add(gradeTitle);
		subPanel.add(gradeInfo);
	}
}