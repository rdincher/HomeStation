package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LightingPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	protected JLabel l;
	protected JButton back;
	
	LightingPanel(){
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
