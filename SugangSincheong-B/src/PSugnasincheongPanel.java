import java.awt.Color;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

import javax.swing.*;

public class PSugnasincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel title = new JLabel("캠퍼스 선택");
	JList<String> camList;
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	JLabel choice;
	private String id;
	private String name;
	private String engName;
	
	public PSugnasincheongPanel () {
		campusReading();
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		 choice = new JLabel(name);
		
		camList = new JList<String>(listModel);
		
		this.setBackground(new Color(255, 204, 213));
		this.add(this.title);
		this.add(camList);
		this.setVisible(true);
	}
	
	public void campusReading () {
		File file = new File("data/root");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			//file read
			while(scanner.hasNext()) {
				System.out.println("야옹 ");
				this.id = scanner.next();
				this.name = scanner.next();
				this.engName = scanner.next();
				 System.out.println("name1: " + name);
				listModel.addElement(name);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}

