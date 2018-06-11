package backend;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
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
	
	WeatherData() throws JSONException, IOException{
		json = JsonReader.readJsonFromUrl("http://api.wunderground.com/api/ff5a2e643163fc5e/forecast/q/IA/Cedar_Rapids.json");
		JSONArray ja = json.getJSONObject("forecast").getJSONObject("simpleforecast").getJSONArray("forecastday");
		wkDay = ja.getJSONObject(0).getJSONObject("date").getString("weekday_short");
		month = ja.getJSONObject(0).getJSONObject("date").getInt("month");
		day = ja.getJSONObject(0).getJSONObject("date").getInt("day");
		high = ja.getJSONObject(0).getJSONObject("high").getString("fahrenheit");
		low = ja.getJSONObject(0).getJSONObject("low").getString("fahrenheit");
		humid = ja.getJSONObject(0).getInt("avehumidity");
		wind = ja.getJSONObject(0).getJSONObject("avewind").getInt("mph");
		windDir = ja.getJSONObject(0).getJSONObject("avewind").getString("dir");
		icon = ja.getJSONObject(0).getString("icon_url");
		fct = ja.getJSONObject(0).getString("conditions");
		System.out.print(icon);
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
		
	}
}
