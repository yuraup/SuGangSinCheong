package View;
import java.awt.Color;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

import javax.swing.*;

public class PSugnasincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PSugnasincheongPanel () {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		PDirectoryPanel pDirectoryPanel = new PDirectoryPanel();
		this.add(pDirectoryPanel);		
		
		this.setBackground(new Color(255, 204, 213));
		this.setVisible(true);
	}
}

