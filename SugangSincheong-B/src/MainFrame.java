import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private EAccount eAccount;
	@SuppressWarnings("deprecation")
	public MainFrame() {
		// attributes
		this.setSize(500, 500);
		setLocationRelativeTo(null);
		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);  
		
		SugnasincheongPanel sugangsincheongPanel = new SugnasincheongPanel();
		this.add(sugangsincheongPanel, BorderLayout.CENTER);
		
		LoginDialog loginDialog = new LoginDialog(null, sugangsincheongPanel);
		loginDialog.show();
		loginDialog.setLocation(530,50);
	}
}
