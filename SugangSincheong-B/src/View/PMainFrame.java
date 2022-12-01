package View;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;

import Global.Constants;
import ValueObject.VAccount;

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
	
		this.vAccount = setVLogin(vAccount); //이게 아닌가여.. 
		// attributes
		this.setSize(Constants.CMainFrame.WIDTH, Constants.CMainFrame.HEIGHT);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		System.out.println("메인프레임: " + this.vAccount);
		
		// vAccount setting 
		this.accountPanel = new PAccountPanel(this.vAccount); //this = mainFrame
		this.add(this.accountPanel, BorderLayout.NORTH);
		
		this.sugnasincheongPanel = new PSugnasincheongPanel();
		this.add(sugnasincheongPanel, BorderLayout.CENTER);
	} 
}