package gui;

import javax.swing.*;
import org.json.JSONException;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

//Swing Tutorial can be found at https://www.javatpoint.com/java-swing

public class FrontPage extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static LandingPanel land = new LandingPanel();
	protected static WeatherPanel wp = new WeatherPanel();
	protected static LightingPanel lp = new LightingPanel();
	static backend.Station s = new backend.Station();

	public FrontPage() {
		add(land);
		add(wp);
		add(lp);

		setLayout(null);
		setSize(480, 320);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("gear.png");
		setIconImage(image);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void callWeather(ActionEvent e) {
		if (e.getSource() == land.weather) {
			wp.setVisible(true);
			// run to get weather data
			try {
				s.runWeather();
			} catch (JSONException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			land.setVisible(false);
		}  else if (e.getSource() == wp.back) {
			land.setVisible(true);
			wp.setVisible(false);
		} 
	}
	
	public static void callLighting(ActionEvent e) {
		if (e.getSource() == land.lights) {
			lp.setVisible(true);
			s.getLights();
			land.setVisible(false);
		} else if (e.getSource() == lp.back) {
			land.setVisible(true);
			lp.setVisible(false);
		}
	}
	
	public void setLights(String[] all){
		for(int i=0; i < 4; i++){
			lp.lights[i] = all[i];
		}
		lp.setLights();
	}
	
	public static void turnOnLight(int num){
		s.turnOnLight(num);
	}
	
	public static void turnOffLight(int num){
		s.turnOffLight(num);
	}
	
	public static void discoLights(){
		s.discoLight();
	}

	public void setWeatherData(String day, String wind, String hi, String lo, String hum, String fct, Icon im,
			int rec) {
		wp.dayData[rec].setText(day);
		wp.windData[rec].setText(wind);
		wp.highData[rec].setText(hi);
		wp.lowData[rec].setText(lo);
		wp.humidityData[rec].setText(hum);
		wp.picData[rec].setIcon(im);
		wp.condData[rec].setText(fct);
		wp.picData[rec].setText("");
	}
}
