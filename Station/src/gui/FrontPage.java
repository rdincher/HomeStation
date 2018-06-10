package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage implements ActionListener{

	JFrame f = new JFrame();
	JPanel front;
	JPanel weatherPanel;
	
	public FrontPage(){
		front = new JPanel();
		front.setBounds(0,0,480,320);    
	    front.setBackground(Color.gray);
	    
	    weatherPanel = new JPanel();
	    weatherPanel.setBounds(0,0,480,320);    
	    weatherPanel.setBackground(Color.gray);
	    
	    JLabel l = new JLabel("Testing");
	    weatherPanel.add(l);
	    weatherPanel.setVisible(false);
	    
		JButton weather = new JButton(new ImageIcon("weather.png"));
		weather.setBounds(10, 10, 100, 100);
		weather.addActionListener(this);
		
		JButton lights = new JButton(new ImageIcon("light.png"));
		lights.setBounds(110, 10, 100, 100);
		lights.addActionListener(this);
		
		JButton cal = new JButton(new ImageIcon("cal.png"));
		cal.setBounds(210, 10, 100, 100);
		cal.addActionListener(this);
		
		front.add(weather);
		front.add(lights);
		front.add(cal);
		front.setVisible(true);
		
		f.add(front);
		f.add(weatherPanel);
		
		f.setLayout(null);
		f.setSize(480,320);  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new FrontPage();  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		weatherPanel.setVisible(true);
		front.setVisible(false);
	}

}
