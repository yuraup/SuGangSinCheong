import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SuccessPanel extends JPanel{
	private EAccount eAccount;
	
	public void SuccessPanel(String name) {
//		VLogin vLogin = this.eAccount.getLogin(name);
		
//		LayoutManager layoutManager = new GridLayout(3, 2);
//		this.setLayout(layoutManager);
//		this.setBackground(Color.green);
		JLabel text2 = new JLabel("dd");
		JLabel text = new JLabel("환영합니다" + name);
		this.add(text);
		this.add(text2);
		System.out.println("dhdld");
		this.setVisible(true);

	}

	
}
