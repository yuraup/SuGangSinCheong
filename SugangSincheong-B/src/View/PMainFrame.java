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
	
	public VAccount setVLogin(VAccount vAccount) { //this.vAccount에 저장 
		this.vAccount = vAccount;
		return this.vAccount;
	}
	
	public PMainFrame(VAccount vAccount) { 
		this.vAccount = setVLogin(vAccount);
		
		// attributes
		this.setSize(Constants.CMainFrame.WIDTH, Constants.CMainFrame.HEIGHT);
		setLocationRelativeTo(null); //중앙 정렬 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료 클릭시 터미널도 종료 
		
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