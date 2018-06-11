package backend;

import java.io.IOException;

import org.json.JSONException;

public class Station {
	
	static gui.FrontPage fp;
	static WeatherData wd;
	static LightingData ld;
	
	public static void main(String[] args) throws Exception {
		wd = new WeatherData();
		ld = new LightingData();
		fp = new gui.FrontPage();
		
	}
	
	public void getLights(){
		try {
			ld.getLights();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void setLightList(){
		fp.setLights(ld.myLights);
	}
	
	public void runWeather() throws JSONException, IOException{
		wd.runWeather();
	}
	
	protected static void setWeather(int num){
		fp.setWeatherData(wd.forDay, wd.forWind, wd.forHigh, wd.forLow, wd.forHumid, wd.forFct, wd.icon2, num);
	}

}
