package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

import javax.swing.*;

import ValueObject.VAccount;

public class PAccountPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private VAccount vAccount;
	private PMyPage pMyPage;
	
	public PAccountPanel(VAccount vAccount) {
		this.setBackground(new Color(255, 245, 158));
		JLabel name = new JLabel(vAccount.getName());
		this.add(name);
		
		JLabel insa = new JLabel("님 안녕하세요!");
		this.add(insa);
		
		JLabel login = new JLabel("로그인 시간은 ");
		this.add(login);
		
		this.vAccount = a(vAccount);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		JLabel time = new JLabel(simpleDateFormat.format(new Date()));
		this.add(time);
		
		JLabel text = new JLabel("입니다. ");
		this.add(text);
		
		JButton myPage = new JButton("마이페이지");
		myPage.setBackground(new Color(178, 223, 196));
		myPage.addActionListener(this);
		this.add(myPage);
		
		JButton news = new JButton("학교소식");
		news.setBackground(new Color(178, 223, 196));
		news.addActionListener(this);
		this.add(news);
		
		JButton link = new JButton("학교홈페이지");
		link.setBackground(new Color(178, 223, 196));
		link.addActionListener(this);
		this.add(link);
		
		JButton exit = new JButton("종료");
		exit.setBackground(new Color(178, 223, 196));
		exit.addActionListener(this);
		this.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonRoute = e.getActionCommand();
		
		if (buttonRoute == "종료") {
			System.exit(0);
			System.out.println("프로그램을 종료합니다. ");
			
		} else if (buttonRoute == "마이페이지") {
			this.pMyPage = new PMyPage(null, this.vAccount);
			pMyPage.setVisible(true);
			System.out.println("마이페이지 눌렸음 ");
			
		} else if (buttonRoute == "학교소식") {
			newsList();
			String cookieResult = newsList();			
			JOptionPane.showMessageDialog(null, cookieResult, "명지대학교 소식", JOptionPane.INFORMATION_MESSAGE);
		
		} else if (buttonRoute == "학교홈페이지") {
			String mjuLink = "http://www.mju.ac.kr/";
			JOptionPane.showMessageDialog(null, mjuLink, "명지대학교 이동", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private String newsList() {
		String[] luckyMessage = new String[5]; 
		luckyMessage[0] = "ict SW경진대회 1회가 끝이 났습니다.";
		luckyMessage[1] = "ict 취업 현황이 매우 긍정적입니다. ";
		luckyMessage[2] = "교내 수강신청 일정은 12월 0일 ~ 12월 0일입니다.";
		luckyMessage[3] = "2022 동계 방학 기숙사 신청기간은 00월 00일까지입니다.";
		String randomMessage = luckyMessage[(int)(Math.random()*4)]; //난수 발생시켜서 랜덤 메시지 출력 
		return randomMessage;
	}
	
	public VAccount a (VAccount vAccount) {
		System.out.println("마이페이지2 vAccount" + vAccount);
		this.vAccount = vAccount;
		return this.vAccount;
	}
}