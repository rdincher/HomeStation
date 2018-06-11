package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage extends JFrame{
	private static final long serialVersionUID = 1L;
	protected static LandingPanel land = new LandingPanel();
	protected static WeatherPanel wp = new WeatherPanel();
	protected static LightingPanel lp = new LightingPanel(); 
	
	public FrontPage(){
		add(land);
		add(wp);
		add(lp);
		
		setLayout(null);
		setSize(480,320);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("gear.png");
		setIconImage(image);
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void actionPerformed(ActionEvent e) {
		if(e.getSource() == land.weather){
			wp.setVisible(true);
			land.setVisible(false);
		} else if(e.getSource() == land.lights){
			lp.setVisible(true);
			land.setVisible(false);
		}else if(e.getSource() == wp.back){
			land.setVisible(true);
			wp.setVisible(false);
		}else if(e.getSource() == lp.back){
			land.setVisible(true);
			lp.setVisible(false);
		}
	}
	
	public void setWeatherData(String day, String wind, String hi, String lo, String hum, String fct, Icon im){
		wp.dayData.setText(day);
		wp.windData.setText(wind);
		wp.highData.setText(hi);
		wp.lowData.setText(lo);
		wp.humidityData.setText(hum);
		wp.picData.setIcon(im);
		wp.condData.setText(fct);
		wp.picData.setText("");
	}
}
