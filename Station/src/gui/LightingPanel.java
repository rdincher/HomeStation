package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LightingPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected String[] lights;
	protected JButton back;
	public final JLabel lightLabel = new JLabel();
	@SuppressWarnings("rawtypes")
	final JComboBox cb = new JComboBox();

	LightingPanel() {
		
		setUp();
	}

	@SuppressWarnings("unchecked")
	protected void setUp() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setBounds(0, 0, 480, 320);
		setBackground(Color.gray);

		back = new JButton("Back");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
		// c.anchor = GridBagConstraints.PAGE_START; // top of space
		back.setBounds(0, 0, 20, 10);
		back.addActionListener(this);
		add(back, c);
		
		lightLabel.setText(null);
		lightLabel.setHorizontalAlignment(JLabel.CENTER);
		lightLabel.setSize(400, 100);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
		add(lightLabel, c);
		
		JButton b = new JButton("Show");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
		add(b, c);
		
		lights = new String[4];
		for (int i = 0; i <= 3; i++) {
			lights[i] = "Temp";
			cb.addItem(lights[i]);
		}
		
		
		cb.setBounds(50, 100, 90, 20);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		add(cb, c);
		
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = (String) cb.getItemAt(cb.getSelectedIndex());
				lightLabel.setText(data);
			}
		});
		
		setVisible(false);
	}

	@SuppressWarnings("unchecked")
	protected void setLights(){
		cb.removeAllItems();
		for (int i = 0; i <= 3; i++) {
			cb.addItem(lights[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FrontPage.callLighting(e);
	}
}
