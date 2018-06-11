package backend;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.json.*;

public class WeatherData {
	
	JsonReader jr = new JsonReader();
	JSONObject json;
	String wkDay, windDir, icon, fct;
	Icon icon2;
	int month, day, humid, wind;
	String high, low;
	String forDay, forWind, forHigh, forLow, forHumid, forFct;
	Image img;
	
	WeatherData() {
		
	}
	
	public void runWeather() throws JSONException, IOException{
		parseJson();
	}
	
	private void parseJson() throws JSONException, IOException{
		
		json = JsonReader.readJsonFromUrl("http://api.wunderground.com/api/ff5a2e643163fc5e/forecast/q/IA/Cedar_Rapids.json");
		JSONArray ja = json.getJSONObject("forecast").getJSONObject("simpleforecast").getJSONArray("forecastday");
		for(int j = 0; j<3; j++){
		wkDay = ja.getJSONObject(j).getJSONObject("date").getString("weekday_short");
		month = ja.getJSONObject(j).getJSONObject("date").getInt("month");
		day = ja.getJSONObject(j).getJSONObject("date").getInt("day");
		high = ja.getJSONObject(j).getJSONObject("high").getString("fahrenheit");
		low = ja.getJSONObject(j).getJSONObject("low").getString("fahrenheit");
		humid = ja.getJSONObject(j).getInt("avehumidity");
		wind = ja.getJSONObject(j).getJSONObject("avewind").getInt("mph");
		windDir = ja.getJSONObject(j).getJSONObject("avewind").getString("dir");
		icon = ja.getJSONObject(j).getString("icon_url");
		fct = ja.getJSONObject(j).getString("conditions");
		System.out.println(wkDay);
		setData(j);
		}
	}
	
	private void setData(int iter) throws MalformedURLException{
		forDay = "<html>" + wkDay + "<br/>" + month + "/" + day + "</html>";
		forWind = wind + " " + windDir;
		forHigh = high;
		forLow = low;
		forHumid = String.valueOf(humid);
		forFct = fct;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL url = new URL(icon);
		img = toolkit.getImage(url);
		icon2 = new ImageIcon(img);	
		Station.setWeather(iter);
	}
}
