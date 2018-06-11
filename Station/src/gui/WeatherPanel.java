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
	protected JLabel[] dayData, highData, lowData, humidityData, windData, condData, picData;

	protected JButton back;
	GridLayout gl = new GridLayout(3, 7);

	WeatherPanel() {

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setBounds(0, 0, 480, 320);
		setBackground(Color.gray);
		dayData = new JLabel[3]; highData = new JLabel[3]; lowData = new JLabel[3];
		humidityData = new JLabel[3]; windData = new JLabel[3]; condData = new JLabel[3];
		picData = new JLabel[3];
		
		setHeader(c);
		for(int i = 0; i < 3; i++){
			setData(c, i);
		}
		
		setVisible(false);
	}
	
	private void setHeader(GridBagConstraints c){
		back = new JButton("<-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		back.setBounds(0, 0, 20, 10);
		back.addActionListener(this);
		add(back, c);

		day = new JLabel("Day");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(day, c);
		
		high = new JLabel("High");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(high, c);
		
		low = new JLabel("Low");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(low, c);
		
		humidity = new JLabel("Humid");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(humidity, c);
		
		wind = new JLabel("Wind");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START; // top of space
		add(wind, c);
		
		cond = new JLabel("Conditions");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
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

	private void setData(GridBagConstraints c, int index){


		dayData[index] = new JLabel("dayData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = index + 3;
		add(dayData[index], c);
		
		highData[index] = new JLabel("HighData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = index + 3;
		add(highData[index], c);
		
		lowData[index] = new JLabel("LowData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = index + 3;
		add(lowData[index], c);
		
		humidityData[index] = new JLabel("HumidData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = index + 3;
		add(humidityData[index], c);
		
		windData[index] = new JLabel("WindData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = index + 3;
		add(windData[index], c);
		
		condData[index] = new JLabel("ConditionsData");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = index + 3;
		add(condData[index], c);
		
		picData[index] = new JLabel("Test");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 6;
		c.gridy = index + 3;
		add(picData[index], c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FrontPage.callWeather(e);
	}

}
