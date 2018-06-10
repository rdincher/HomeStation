package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WeatherPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected JLabel l;
	JButton back;
	
	WeatherPanel(){
		 setBounds(0,0,480,320);
		 setBackground(Color.gray);
		 
		 back = new JButton("Back");
		 back.setBounds(0, 10, 60, 30);
		 back.addActionListener(this);
		 add(back);
		 
		 l = new JLabel("Testing");
		 l.setBounds(220, 50, 40, 30);
		 add(l);
		 
		 setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FrontPage.actionPerformed(e);
	}
	
}
