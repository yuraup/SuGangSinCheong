package View.SugangSincheong;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PCountPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PCountPanel (int miriNum) {
//		this.setBackground(new Color(255, 245, 158));
		showCount(miriNum);
	}
	public void showCount (int miriNum) {
		
		JLabel text = new JLabel("담은 강좌 수 : "); 
		this.add(text);
		
		JLabel number = new JLabel(Integer.toString(miriNum));
		this.add(number);
	}
}
