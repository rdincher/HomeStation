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

	public void getLights() {
		try {
			ld.getLights();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void setLightList() {
		fp.setLights(ld.myLights);
	}

	public void turnOnLight(int num) {
		try {
			ld.turnOn(num + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void turnOffLight(int num) {
		try {
			ld.turnOff(num + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void discoLight() {
		if (ld.disco) {
			try {
				ld.stopDisco();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ld.disco = false;
		}else if(!ld.disco){
			try {
				ld.disco();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ld.disco = true;
		}
	}

	public void runWeather() throws JSONException, IOException {
		wd.runWeather();
	}

	protected static void setWeather(int num) {
		fp.setWeatherData(wd.forDay, wd.forWind, wd.forHigh, wd.forLow, wd.forHumid, wd.forFct, wd.icon2, num);
	}

}
