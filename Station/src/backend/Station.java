package backend;

import java.io.IOException;

import org.json.JSONException;

public class Station {
	
	static gui.FrontPage fp;
	static WeatherData wd;
	
	public static void main(String[] args) throws JSONException, IOException {
		wd = new WeatherData();
		fp = new gui.FrontPage();
		
	}
	
	public void runWeather() throws JSONException, IOException{
		wd.runWeather();
	}
	
	protected static void setWeather(int num){
		fp.setWeatherData(wd.forDay, wd.forWind, wd.forHigh, wd.forLow, wd.forHumid, wd.forFct, wd.icon2, num);
	}

}
