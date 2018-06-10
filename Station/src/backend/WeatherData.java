package backend;

import java.io.IOException;

import org.json.*;

public class WeatherData {
	
	JsonReader jr = new JsonReader();
	JSONObject json;
	String wkDay, windDir, icon, fct;
	int month, day, high, low, humid, wind;
	
	WeatherData() throws JSONException, IOException{
		json = JsonReader.readJsonFromUrl("http://api.wunderground.com/api/ff5a2e643163fc5e/forecast10day/q/IA/Cedar_Rapids.json");
		JSONArray ja = json.getJSONObject("forecast").getJSONObject("simpleforecast").getJSONArray("forecastday");
		wkDay = ja.getJSONObject(0).getJSONObject("date").getString("weekday_short");
		month = ja.getJSONObject(0).getJSONObject("date").getInt("month");
		day = ja.getJSONObject(0).getJSONObject("date").getInt("day");
		high = ja.getJSONObject(0).getJSONObject("high").getInt("fahrenheit");
		low = ja.getJSONObject(0).getJSONObject("low").getInt("fahrenheit");
		humid = ja.getJSONObject(0).getInt("avehumidity");
		wind = ja.getJSONObject(0).getJSONObject("avewind").getInt("mph");
		windDir = ja.getJSONObject(0).getJSONObject("avewind").getString("dir");
		icon = ja.getJSONObject(0).getString("icon_url");
		icon = ja.getJSONObject(0).getString("conditions");
	}
}
