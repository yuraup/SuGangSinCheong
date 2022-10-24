import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private EAccount eAccount;
	public MainFrame() {
		// attributes
		this.setSize(400, 600);
		
		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		LoginPanel loginPanel = new LoginPanel();
		this.add(loginPanel, BorderLayout.NORTH);
		
		SugnasincheongPanel sugnasincheongPanel = new SugnasincheongPanel();
		this.add(sugnasincheongPanel, BorderLayout.CENTER);
		
		SuccessPanel successPanel = new SuccessPanel();
		this.add(successPanel, BorderLayout.SOUTH);
	}
}
