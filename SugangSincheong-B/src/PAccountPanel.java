import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class PAccountPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PAccountPanel(VAccount vAccount) {
		this.setBackground(new Color(255, 245, 158));
		JLabel JName = new JLabel(vAccount.getName());
		this.add(JName);
		
		JLabel JInsa = new JLabel("님 안녕하세요!");
		this.add(JInsa);
		
		JLabel JLogin = new JLabel("로그인 시간은 ");
		this.add(JLogin);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		JLabel JTime = new JLabel(simpleDateFormat.format(new Date()));
		this.add(JTime);
		
		JLabel JText = new JLabel("입니다. ");
		this.add(JText);
		
	}
}
