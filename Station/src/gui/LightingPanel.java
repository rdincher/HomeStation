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
		setLayout(null);
		setBounds(0, 0, 480, 320);
		setBackground(Color.gray);

		back = new JButton("Back");
		back.setBounds(0, 0, 75, 30);
		back.addActionListener(this);
		add(back);
		
		lightLabel.setText(null);
		lightLabel.setHorizontalAlignment(JLabel.LEFT);
		lightLabel.setBounds(225, 50, 175, 20);
		add(lightLabel);
		
		JButton b = new JButton("Show");
		b.setBounds(300, 0, 75, 30);
		add(b);
		
		lights = new String[4];
		for (int i = 0; i <= 3; i++) {
			lights[i] = "Temp";
			cb.addItem(lights[i]);
		}
		
		
		cb.setBounds(0, 50, 175, 20);
		add(cb);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = (String) cb.getItemAt(cb.getSelectedIndex());
				lightLabel.setText(data);
			}
		});
		
		JButton on = new JButton("On");
		on.setBounds(100, 0, 50, 30);
		add(on);
		JButton off = new JButton("Off");
		off.setBounds(150, 0, 50, 30);
		add(off);
		JButton disco = new JButton("DISCO");
		disco.setBounds(200, 0, 75, 30);
		add(disco);
		
		on.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind = cb.getSelectedIndex();
				lightLabel.setText(Integer.toString(ind));
				FrontPage.turnOnLight(ind);
			}
		});
		
		off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind = cb.getSelectedIndex();
				lightLabel.setText(Integer.toString(ind));
				FrontPage.turnOffLight(ind);
			}
		});
		
		disco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lightLabel.setText("Disco");
				FrontPage.discoLights();
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
