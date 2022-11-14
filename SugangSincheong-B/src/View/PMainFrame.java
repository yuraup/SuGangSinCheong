package View;
import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import ValueObject.VAccount;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private PAccountPanel accountPanel;
	
	private VAccount vAccount;
	private PSugnasincheongPanel sugnasincheongPanel;
	public void setVLogin(VAccount vAccount) {
		this.vAccount = vAccount;
	}
	public PMainFrame() {
		this.vAccount = null;
		
		// attributes
		this.setSize(1800, 1000);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// components
		// vAccount setting 
		PLoginDialog loginDialog = new PLoginDialog(this);
		loginDialog.setVisible(true);
		
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);  
		
		this.accountPanel = new PAccountPanel(this.vAccount); //this = mainFrame
		this.add(this.accountPanel, BorderLayout.NORTH);
		
		this.sugnasincheongPanel = new PSugnasincheongPanel();
		this.add(sugnasincheongPanel, BorderLayout.CENTER);
		

	} 
}
