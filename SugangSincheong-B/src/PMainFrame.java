import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private EAccount eAccount;
	private PAccountPanel accountPanel;
	@SuppressWarnings("deprecation")
	public PMainFrame() {
		// attributes
		this.setSize(500, 500);
		setLocationRelativeTo(null);
		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);  
		
		PSugnasincheongPanel sugangsincheongPanel = new PSugnasincheongPanel();
		this.add(sugangsincheongPanel, BorderLayout.CENTER);
		
		this.accountPanel = new PAccountPanel(); //this = mainFrame
		//과제는위 코드에 VAccount를 넘기셈 .내아이디비번회원정보 다 VAccount에담아서 넘기셈 
		this.add(this.accountPanel, BorderLayout.NORTH);
		
		PLoginDialog loginDialog = new PLoginDialog(null, this.accountPanel);
		loginDialog.show();
	} //로그인이라는 함수는 로그인 뷰에서 가지고 와야 함. 
}
