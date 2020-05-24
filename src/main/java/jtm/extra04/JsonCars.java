package jtm.extra04;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

import com.google.gson.Gson;


public class JsonCars {

	/*- TODO #1
	 * Implement method, which returns list of cars from generated JSON string
	 */
	public List<Car> getCars(String jsonString) throws JSONException{
		/*- HINTS:
		 * You will need to use:
		 * - https://stleary.github.io/JSON-java/org/json/JSONObject.html
		 * - https://stleary.github.io/JSON-java/org/json/JSONArray.html
		 * You will need to initialize JSON array from "cars" key in JSON string
		 */
		List<Car> output = new ArrayList<>();     
		JSONObject json = new JSONObject(jsonString);
		JSONArray arr = json.getJSONArray("cars");
		
		if (arr != null) { 
			   for (int i=0;i<arr.length();i++){ 
				    JSONObject o = (JSONObject) arr.get(i);
			        output.add(new Car(o.getString("model"), o.getInt("year"), o.getString("color"),o.getFloat("price")));
			      } 
		}
			return output;
	}

	/*- TODO #2
	 * Implement method, which returns JSON String generated from list of cars
	 */
	public String getJson(List<Car> cars) {
		/*- HINTS:
		 * You will need to use:
		 * - https://docs.oracle.com/javase/8/docs/api/index.html?java/io/StringWriter.html
		 * - http://static.javadoc.io/org.json/json/20180130/index.html?org/json/JSONWriter.html
		 * Remember to add "car" key as a single container for array of car objects in it.
		 */
		return null;
	}

}