package View;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ValueObject.VLecture;

   public class PSugnasincheongPanel extends JPanel {
   private static final long serialVersionUID = 1L;

   private PDirectoryPanel directoryPanel;
   
   private PControlPanel1 controlPanel1;
   private PControlPanel2 controlPanel2;
   private PMiriDamgiPanel miridamgiPanel;
   private PSincheongPanel sincheongPanel;
   
   public PSugnasincheongPanel() {

      ActionHandler actionHandler = new ActionHandler();
      
      LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
      this.setLayout(layoutManager);
      
      this.directoryPanel = new PDirectoryPanel();
      this.add(this.directoryPanel);
      
      this.controlPanel1 = new PControlPanel1("1", actionHandler);
      this.add(this.controlPanel1);
      
      JScrollPane scrollPane = new JScrollPane();
      this.miridamgiPanel = new PMiriDamgiPanel();
      scrollPane.setViewportView(this.miridamgiPanel);
      this.add(scrollPane);
      
      this.controlPanel2 = new PControlPanel2("2", actionHandler);
      this.add(this.controlPanel2);
      
      scrollPane = new JScrollPane();
      this.sincheongPanel = new PSincheongPanel();
      scrollPane.setViewportView(this.sincheongPanel);
      this.add(scrollPane);
   }
   
   private void moveFromLecturesToMiridamgi() {
      Vector<VLecture> lectures = this.directoryPanel.getSelectedLecture();
      this.miridamgiPanel.addLectures(lectures);
   }
   private void moveFromMiridamgiToLectures() {
      Vector<VLecture> lectures = this.miridamgiPanel.getSelectedLecture();
      this.directoryPanel.addLectures(lectures);
   }
   private void moveFromMiridamgiToSincheong() {
      Vector<VLecture> lectures = this.miridamgiPanel.getSelectedLecture();
      this.sincheongPanel.addLectures(lectures);
   }
   private void moveFromSincheongToMiridamgi() {
      Vector<VLecture> lectures = this.sincheongPanel.getSelectedLecture();
      this.miridamgiPanel.addLectures(lectures);
   }
   
   public class ActionHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getActionCommand().compareTo("1>>") == 0) {
            System.out.println("1>>");
            moveFromLecturesToMiridamgi();
         } else if(e.getActionCommand().compareTo("1<<") == 0) {
            System.out.println("1<<");
            moveFromMiridamgiToLectures();
         } else if(e.getActionCommand().compareTo("2>>") == 0) {
            System.out.println("2>>");
            moveFromMiridamgiToSincheong();
         } else if(e.getActionCommand().compareTo("2<<") == 0) {
            System.out.println("2<<");
            moveFromSincheongToMiridamgi();
         }
         
      }
      
   }
}
