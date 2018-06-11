package backend;

import org.json.*;

public class LightingData {
	JsonReader jr = new JsonReader();
	HttpComm hc = new HttpComm();
	String[] myLights;
	
	LightingData(){
		myLights = new String[4];
	}
	
	protected void getLights() throws Exception{
		String myJSon = hc.sendGet("http://192.168.2.5/api/NNNcEcM5gL2AN7EnHzXbyLQkSzg6kwAF0y83DGip");
		JSONObject js = new JSONObject(myJSon);
		for(int i=0; i< 4; i++){
			myLights[i] = js.getJSONObject("lights").getJSONObject(Integer.toString(i+1)).getString("name");
		}
		Station.setLightList();
		/*for ($x = 1; $x <= 4; $x++)
		  {
		  	$lightID = $x;
		  	$high = $parsed_json->{'lights'}->{$x}->{'name'};
		  	?>*/
	}
	
}
