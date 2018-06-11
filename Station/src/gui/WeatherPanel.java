package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class WeatherPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	protected JLabel day, high, low, humidity, wind, cond, pic;
	protected JLabel dayData, highData, lowData, humidityData, windData, condData, picData;
	protected JLabel dayData1, highData1, lowData1, humidityData1, windData1, condData1, picData1;
	protected JLabel dayData2, highData2, lowData2, humidityData2, windData2, condData2, picData2;
	protected JButton back;
	GridLayout gl = new GridLayout(3, 7);

	WeatherPanel() {

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setBounds(0, 0, 480, 320);
		setBackground(Color.gray);

		setHeader(c);
		setData(c);
		
		setVisible(false);
	}
	
	private void setHeader(GridBagConstraints c){
		back = new JButton("<-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		//c.anchor = GridBagConstraints.PAGE_START; // top of space
		back.setBounds(0, 0, 20, 10);
		back.addActionListener(this);
		add(back, c);

		day = new JLabel("Day");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(day, c);
		
		high = new JLabel("High");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(high, c);
		
		low = new JLabel("Low");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(low, c);
		
		humidity = new JLabel("Humid");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(humidity, c);
		
		wind = new JLabel("Wind");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 6;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(wind, c);
		
		cond = new JLabel("Conditions");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 7;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(cond, c);
		
		/*pic = new JLabel("pic");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 8;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(pic, c);*/
	}

	private void setData(GridBagConstraints c){


		dayData = new JLabel("dayData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		add(dayData, c);
		
		highData = new JLabel("HighData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 2;
		add(highData, c);
		
		lowData = new JLabel("LowData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 2;
		add(lowData, c);
		
		humidityData = new JLabel("HumidData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 2;
		add(humidityData, c);
		
		windData = new JLabel("WindData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 6;
		c.gridy = 2;
		add(windData, c);
		
		condData = new JLabel("ConditionsData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 7;
		c.gridy = 2;
		add(condData, c);
		
		picData = new JLabel("Test");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 8;
		c.gridy = 2;
		add(picData, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FrontPage.actionPerformed(e);
	}

}
