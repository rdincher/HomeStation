package gui;

import javax.swing.*;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

public class FrontPage extends JFrame{
	private static final long serialVersionUID = 1L;
	static LandingPanel lp = new LandingPanel();
	static WeatherPanel wp = new WeatherPanel();
	
	
	public FrontPage(){
		add(lp);
		add(wp);
		
		setLayout(null);
		setSize(480,320);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("gear.png");
		setIconImage(image);
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void actionPerformed(ActionEvent e) {
		if(e.getSource() == lp.weather){
			wp.setVisible(true);
			lp.setVisible(false);
		} else if(e.getSource() == wp.back){
			lp.setVisible(true);
			wp.setVisible(false);
		}
		
	}
}
