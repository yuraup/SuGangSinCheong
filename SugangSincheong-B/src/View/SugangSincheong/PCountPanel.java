package View.SugangSincheong;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PCountPanel extends JPanel { //미리담기 강좌 개수 
	private static final long serialVersionUID = 1L;
	
	JLabel number;
	public PCountPanel (int miriNum) { //row 개수를 받아와 UI에 개수를 표시한다. 
		showCount(miriNum);
	}
	
	public void showCount (int miriNum) {
		JLabel text = new JLabel("담은 강좌 수 : "); 
		this.add(text);
		
		number = new JLabel(Integer.toString(miriNum));
		this.add(number);
	}
	
	public void againShow (int miridamgiNumber) { //컨트롤 버튼에 따른 개수 변화 표시 
		number.setText(Integer.toString(miridamgiNumber));
	}
}
