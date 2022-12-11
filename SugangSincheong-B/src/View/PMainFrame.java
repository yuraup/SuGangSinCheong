package View;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;

import Global.Constants;
import ValueObject.VAccount;
import View.SugangSincheong.PSugnasincheongPanel;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private PAccountPanel accountPanel;
	
	private VAccount vAccount;
	private PSugnasincheongPanel sugnasincheongPanel;
	
	public VAccount setVLogin(VAccount vAccount) {
		this.vAccount = vAccount;
		return this.vAccount;
	}
	
	public PMainFrame(VAccount vAccount) { 
	
		this.vAccount = setVLogin(vAccount);
		
		// attributes
		this.setSize(Constants.CMainFrame.WIDTH, Constants.CMainFrame.HEIGHT);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		// vAccount setting 
		this.accountPanel = new PAccountPanel(this.vAccount);
		this.add(this.accountPanel, BorderLayout.NORTH);
		
		this.sugnasincheongPanel = new PSugnasincheongPanel();
		this.add(sugnasincheongPanel, BorderLayout.CENTER);
	} 
}