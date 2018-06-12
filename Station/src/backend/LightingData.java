package backend;

import org.json.*;

public class LightingData {
	JsonReader jr = new JsonReader();
	HttpComm hc = new HttpComm();
	String[] myLights;
	boolean disco = false;

	LightingData() {
		myLights = new String[4];
	}

	protected void getLights() throws Exception {
		String myJSon = hc.sendGet("http://192.168.2.5/api/NNNcEcM5gL2AN7EnHzXbyLQkSzg6kwAF0y83DGip");
		JSONObject js = new JSONObject(myJSon);
		for (int i = 0; i < 4; i++) {
			myLights[i] = js.getJSONObject("lights").getJSONObject(Integer.toString(i + 1)).getString("name");
		}
		Station.setLightList();
	}

	protected void turnOn(int lightId) throws Exception{
		String url = "http://192.168.2.5/api/NNNcEcM5gL2AN7EnHzXbyLQkSzg6kwAF0y83DGip/lights/"+ lightId +"/state";
		hc.sendPut(url, "{\"on\":true}");
	}

	protected void turnOff(int lightId) throws Exception{
		String url = "http://192.168.2.5/api/NNNcEcM5gL2AN7EnHzXbyLQkSzg6kwAF0y83DGip/lights/"+ lightId +"/state";
		hc.sendPut(url, "{\"on\":false}");
    }

	protected void disco() throws Exception {
		hc.sendPut("http://192.168.2.5/api/NNNcEcM5gL2AN7EnHzXbyLQkSzg6kwAF0y83DGip/groups/0/action",
				"{\"effect\":\"colorloop\"}");

	}

	protected void stopDisco() throws Exception {
		hc.sendPut("http://192.168.2.5/api/NNNcEcM5gL2AN7EnHzXbyLQkSzg6kwAF0y83DGip/groups/0/action",
				"{\"effect\":\"none\"}");
	}
	
	//TODO: Add Brightness Control
	
}
