import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowTwo extends JPanel {
	public void windowTwo() {
		LayoutManager layoutManager = new GridLayout(3, 2);
		this.setLayout(layoutManager);
		
		JLabel failurePanel = new JLabel("로그인에 실패했습니다.");
		this.add(failurePanel);
		failurePanel.setBackground(Color.pink);
		
		setVisible(true);

	}
}
