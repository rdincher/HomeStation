package gui;

import javax.swing.*;
import java.awt.event.*;

public class FrontPage extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	public FrontPage(){
		JLabel l = new JLabel();
		l.setBounds(0, 0, 10, 10);
		add(l);
		JButton weather = new JButton(new ImageIcon("weather.png"));
		weather.setBounds(10, 10, 100, 100);
		weather.addActionListener(this);
		
		JButton lights = new JButton(new ImageIcon("light.png"));
		lights.setBounds(110, 10, 100, 100);
		lights.addActionListener(this);
		
		JButton cal = new JButton(new ImageIcon("cal.png"));
		cal.setBounds(210, 10, 100, 100);
		cal.addActionListener(this);
		
		add(weather);
		add(lights);
		add(cal);
		
		setSize(480, 320);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrontPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
