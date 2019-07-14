package com.bunker.code;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.bunker.code.model.URLData;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class HTTPEndClient {
	
	public static void main(String[] args) throws IOException {
		String url = "https://api.cybergator.co.uk/testing/devices";
		//more useful way to consume a REST web service using Spring RestTemplate
		//Code to make a URL call and read JSON data
		RestTemplate restTemplate = new RestTemplate();
    	//ResponseEntity<JSONArray> responseEntity = restTemplate.getForEntity(url, JSONArray.class);

    	//since its a hardcoded JSON lets use ObjectMapper
       	ObjectMapper mapper = new ObjectMapper();
        try {
        	JSONArray resultData = mapper.readValue(new File("src/main/resources/input.json"), JSONArray.class);
        	
        	for (Object json : resultData) {
        		URLData data = evaluateJSON(mapper, mapper.writeValueAsString(json));	
        		System.out.println(data.toString());
        	}        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new IOException("File Not Found");
        }
	}
	
    public static URLData evaluateJSON(ObjectMapper mapper, String json) throws IOException {
    	JSONObject mJSONObject = mapper.readValue(json, JSONObject.class);
    	URLData data = null;
    	//since its not a static key, do this
		Set<?> keys = mJSONObject.keySet();
		Iterator<?> a = keys.iterator();
				
		while(a.hasNext()) {
			String key = (String)a.next();
			// loop to get the dynamic key
			Object value = mJSONObject.get(key);				    
			data = mapper.readValue(mapper.writeValueAsString(value), URLData.class);
		}
		return data;
    }
}
