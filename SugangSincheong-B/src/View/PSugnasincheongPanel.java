package View;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.*;

public class PSugnasincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private PDirectoryPanel directoryPanel;
	private PControlPanel1 controlPanel1;
	private PControlPanel2 controlPanel2;
	private PMiriDamgiPanel miriDamgiPanel;
	private PSincheongPanel SincheongPanel;
	
	public PSugnasincheongPanel () {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		this.directoryPanel = new PDirectoryPanel();
		this.add(this.directoryPanel);		
		
		this.controlPanel1 = new PControlPanel1();
		this.add(this.controlPanel1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		this.miriDamgiPanel = new PMiriDamgiPanel();
		scrollPane.setViewportView(this.miriDamgiPanel);
		this.add(scrollPane);
		
		
		this.controlPanel2 = new PControlPanel2();
		this.add(this.controlPanel2);	
		
		scrollPane = new JScrollPane();
		this.SincheongPanel = new PSincheongPanel();
		scrollPane.setViewportView(this.SincheongPanel);
		this.add(scrollPane);
	
		
		this.setVisible(true);
	}
}

