package mmk.json;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonReading {

	public static void main(String[] args) {
		String s = "{\"name\":\"John\", \"age\":30, \"car\":{\"brand\":\"BMW\", \"year\":2019, \"model\":\"1.18i\"}}";
		
		JSONObject jObject = new JSONObject(s);
		System.out.println(jObject.get("car"));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement jse = JsonParser.parseString(s);
		System.out.println(gson.toJson(jse));
	}

}
