package gui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class LandingPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected JButton weather, lights, cal, other;
	
	LandingPanel(){
		setBounds(0,0,480,320);
	    setBackground(Color.gray);
	    
		weather = new JButton(new ImageIcon("weather.png"));
		weather.setBounds(10, 10, 100, 100);
		weather.addActionListener(this);
		
		lights = new JButton(new ImageIcon("light.png"));
		lights.setBounds(110, 10, 100, 100);
		lights.addActionListener(this);
		
		cal = new JButton(new ImageIcon("cal.png"));
		cal.setBounds(210, 10, 100, 100);
		cal.addActionListener(this);
		
		//other = new JButton(new ImageIcon(url));
		//other.setBounds(310, 10, 100, 100);
		//other.addActionListener(this);
		
		add(weather);
		add(lights);
		add(cal);
		//add(other);
		
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FrontPage.actionPerformed(e);
	}

}
