package View.SugangSincheong;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ValueObject.VLecture;
import View.PControlPanel1;
import View.PControlPanel2;

   public class PSugnasincheongPanel extends JPanel {
   private static final long serialVersionUID = 1L;

   private PDirectoryPanel directoryPanel;
   
   private PControlPanel1 controlPanel1;
   private PControlPanel2 controlPanel2;
   
   private JPanel miridamgiBox;
   private PMiriDamgiPanel miridamgiPanel;
   private PCountPanel miriCountPanel;
   
   private JPanel sincheongBox;
   private PSincheongPanel sincheongPanel;
   private PSincheongCountPanel sincheongCountPanel;
   
   int miriNum;
   int sinCheongNum;
   
   public PSugnasincheongPanel() { // UI 
	  LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
	  this.setLayout(layoutManager);
	     
      ActionHandler actionHandler = new ActionHandler();
      
      this.directoryPanel = new PDirectoryPanel();
      this.add(this.directoryPanel);
      
      this.controlPanel1 = new PControlPanel1("1", actionHandler); //id = 1 
      this.add(this.controlPanel1);
      
       //미리담기 판넬 
      miridamgiBox = new JPanel();
      
	  LayoutManager smallManager = new BoxLayout(miridamgiBox, BoxLayout.Y_AXIS);
	  miridamgiBox.setLayout(smallManager);
      
      
      JScrollPane scrollPane = new JScrollPane();
      this.miridamgiPanel = new PMiriDamgiPanel();
      scrollPane.setViewportView(this.miridamgiPanel);
      miridamgiBox.add(scrollPane);
      
      //count 
      this.miriNum = this.miridamgiPanel.countingMiri();
      this.miriCountPanel = new PCountPanel(miriNum);
      miridamgiBox.add(miriCountPanel);
//      System.out.println("오앙ㅇ" + this.miridamgiPanel.setInitMiridamgi());
      this.add(miridamgiBox);
      
      this.controlPanel2 = new PControlPanel2("2", actionHandler); // id = 2
      this.add(this.controlPanel2);
      
      //수강신청 판넬 
      sincheongBox  = new JPanel();
      
	  LayoutManager small2Manager = new BoxLayout(sincheongBox, BoxLayout.Y_AXIS);
	  sincheongBox.setLayout(small2Manager);
      
      scrollPane = new JScrollPane();
      this.sincheongPanel = new PSincheongPanel();
      scrollPane.setViewportView(this.sincheongPanel);
      sincheongBox.add(scrollPane);
      
      //count 
      this.sinCheongNum = this.sincheongPanel.countSincheong();
      this.sincheongCountPanel = new PSincheongCountPanel(sinCheongNum);
      sincheongBox.add(sincheongCountPanel);   
      this.add(sincheongBox);
   }

   private void moveFromLecturesToMiridamgi() { //목록 -> 미리담기 
	  Vector<VLecture> lectures = this.directoryPanel.getSelectedLecture(); //lectures == 선택된 row Vector
	  boolean checkDoublePoint = this.miridamgiPanel.addLectures(lectures); //미리담기에 추가 
      this.directoryPanel.deleteLectures(); //목록에서 삭제
      
      if (checkDoublePoint) {
    	  this.miriNum += 1;
          this.miriCountPanel.againShow(miriNum);  
      }
   }
   private void moveFromMiridamgiToLectures() { //미리담기 -> 목록 
	   Vector<VLecture> lectures = this.miridamgiPanel.getSelectedLecture(); //목록에 추가 
	   this.directoryPanel.addLectures(lectures);//목록에 추가
	   this.miridamgiPanel.deleteLectures(); // 미리담기에서 삭제 
	   
	   this.miriNum -= 1;
	   this.miriCountPanel.againShow(miriNum);
   }
   private void moveFromMiridamgiToSincheong() { // 미리담기 -> 수강신청 
      Vector<VLecture> lectures = this.miridamgiPanel.getSelectedLecture(); 
      this.sincheongPanel.addLectures(lectures);//신청에 추가 
      this.miridamgiPanel.deleteLectures(); // 미리담기에서 삭제 
      
	   this.miriNum -= 1;  // 담기 패널 count -1
	   this.miriCountPanel.againShow(miriNum);
	   
	   this.sinCheongNum += 1; // 신청 패널 count +1
	   this.sincheongCountPanel.againShow(sinCheongNum);
   }
   private void moveFromSincheongToMiridamgi() { // 수강신청 -> 미리담기
	  Vector<VLecture> lectures = this.sincheongPanel.getSelectedLecture(); 
	  this.miridamgiPanel.addLectures(lectures);//미리담기에 추가 
	  this.sincheongPanel.deleteLectures(); //수강신청에서 삭제 
	  
      this.miriNum += 1;
      this.miriCountPanel.againShow(miriNum);
      
	   this.sinCheongNum -= 1; // 신청 패널 count -1
	   this.sincheongCountPanel.againShow(sinCheongNum);
   }
   
   public class ActionHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) { //버튼 이벤트 
         if(e.getActionCommand().compareTo("1>>") == 0) {
            moveFromLecturesToMiridamgi();
         } else if(e.getActionCommand().compareTo("1<<") == 0) {
            moveFromMiridamgiToLectures();
         } else if(e.getActionCommand().compareTo("2>>") == 0) {
            moveFromMiridamgiToSincheong();
         } else if(e.getActionCommand().compareTo("2<<") == 0) {
            moveFromSincheongToMiridamgi();
         }
         
      }
      
   }
}