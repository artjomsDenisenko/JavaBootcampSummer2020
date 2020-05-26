package jtm.extra04;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class JsonCars {

	/*- TODO #1
	 * Implement method, which returns list of cars from generated JSON string
	 */
	public List<Car> getCars(String jsonString) {
		/*- HINTS:
		 * You will need to use:
		 * - https://stleary.github.io/JSON-java/org/json/JSONObject.html
		 * - https://stleary.github.io/JSON-java/org/json/JSONArray.html
		 * You will need to initialize JSON array from "cars" key in JSON string
		 */

		List<Car> output = new ArrayList<>();
		JSONObject json = new JSONObject(jsonString);
		JSONArray arr = json.getJSONArray("cars");
		for (int i = 0; i < arr.length(); i++) {
			JSONObject jsonObj = arr.getJSONObject(i);
			Car data = new Car(jsonObj.getString("model"), jsonObj.getInt("year"), jsonObj.getString("color"),
					jsonObj.getFloat("price"));
			output.add(data);
		}

		return output;
	}

	/*-  #2
	 * Implement method, which returns JSON String generated from list of cars
	 */
	public String getJson(List<Car> cars) {
		/*- HINTS:
		 * You will need to use:
		 * - https://docs.oracle.com/javase/8/docs/api/index.html?java/io/StringWriter.html
		 * - http://static.javadoc.io/org.json/json/20180130/index.html?org/json/JSONWriter.html
		 * Remember to add "car" key as a single container for array of car objects in it.
		 */

		StringWriter stringWriter = new StringWriter();
		JSONWriter writer = new JSONWriter(stringWriter);
		writer.object();
		writer.key("cars");
		writer.array();
		for (Car car : cars) {
			writer.object();
			writer.key("model").value(car.getModel());
			writer.key("year").value(car.getYear());
			writer.key("color").value(car.getColor());
			writer.key("price").value(car.getPrice());
			writer.endObject();
		}
		writer.endArray();
		writer.endObject();

		return stringWriter.toString();
	}

}