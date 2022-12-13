package View.SugangSincheong;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PCountPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel number;
	public PCountPanel (int miriNum) {
		showCount(miriNum);
	}
	public void showCount (int miriNum) {
		
		JLabel text = new JLabel("담은 강좌 수 : "); 
		this.add(text);
		
		number = new JLabel(Integer.toString(miriNum));
		this.add(number);
	}
	
	public void againShow (int miridamgiNumber) {
		number.setText(Integer.toString(miridamgiNumber));
	}
}
