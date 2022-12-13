package View.SugangSincheong;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class PSincheongCountPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel number;
	public PSincheongCountPanel (int sinCheongNum) {
		showCount(sinCheongNum);
	}
	
	public void showCount (int sinCheongNum) {
		
		JLabel text = new JLabel("신청한 강좌 수 : "); 
		this.add(text);
		
		number = new JLabel(Integer.toString(sinCheongNum));
		this.add(number);
	}
	
	public void againShow (int miridamgiNumber) {
		number.setText(Integer.toString(miridamgiNumber));
	}
}
