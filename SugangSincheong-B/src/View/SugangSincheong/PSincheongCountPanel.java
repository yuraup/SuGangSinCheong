package View.SugangSincheong;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class PSincheongCountPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel number;
	
	public PSincheongCountPanel (int sinCheongNum) {
		showCount(sinCheongNum);
	}
	
	public void showCount (int sinCheongNum) {  //row 개수를 받아와 UI에 개수를 표시한다. 
		
		JLabel text = new JLabel("신청한 강좌 수 : "); 
		this.add(text);
		
		number = new JLabel(Integer.toString(sinCheongNum));
		this.add(number);
	}
	
	public void againShow (int miridamgiNumber) { //컨트롤 버튼에 따른 변화 대응 
		number.setText(Integer.toString(miridamgiNumber));
	}
}
