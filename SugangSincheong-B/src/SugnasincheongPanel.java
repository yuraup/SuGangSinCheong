import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SugnasincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel text2 = new JLabel(" ");
	String userName = "";
	
	public SugnasincheongPanel () {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		this.setBackground(new Color(255, 204, 213));
		this.add(this.text2);
		this.setVisible(true);
	}
	
	void hello(VLogin vLogin) {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		String id = vLogin.getId();
		String password =  vLogin.getPassword();
		userName = vLogin.getName();
		this.text2.setText("환영합니다! " + userName + "님!");

		
		}
	}

