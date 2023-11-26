package mmk.rest.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class RestRequestAndStringResponse {

	public static void main(String[] args){
		String link = "/diagnostic";
		
		samplePrint(link);
		System.out.println("---------------------------");

		gsonPrint(link);
		System.out.println("---------------------------");
	}
	private static void samplePrint(String link) {
		try {
			Arrays.asList(RestRequest(link).split(",")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void gsonPrint(String link) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonElement jse = JsonParser.parseString(RestRequest(link));
			System.out.println(gson.toJson(jse));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static String RestRequest(String link) throws IOException{
		URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en" + link.toLowerCase());
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setConnectTimeout(5000);
		http.setReadTimeout(5000);

		int status = http.getResponseCode();
		System.out.println(status);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
		String line = "";
		StringBuffer responceContent = new StringBuffer();
		
		while((line = reader.readLine()) != null) {
			responceContent.append(line);
		}
		reader.close();
		http.disconnect();
		
		return responceContent.toString();
	}

}
