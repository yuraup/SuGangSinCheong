package View.SugangSincheong;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class PSincheongCountPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PSincheongCountPanel (int sinCheongNum) {
//		this.setBackground(new Color(255, 245, 158));
		
		JLabel text = new JLabel("신청한 강좌 수 : "); 
		this.add(text);
		
		JLabel number = new JLabel("3");
		this.add(number);
	}
}
