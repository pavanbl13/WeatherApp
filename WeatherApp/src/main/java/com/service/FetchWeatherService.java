package com.service;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.model.Weather;

@Service
public class FetchWeatherService {
	public Double getWeather(Weather pojo) {
		double finalTemp  = 0.0;
	    try {
	    	RestTemplate rest = new RestTemplate();
	    	String url = pojo.getWeatherURL();
	    	url.replace("#", pojo.getCity());
	    	url.replace("@", pojo.getCountry());
	    	String response = rest.getForObject(url,String.class);
	    	Gson gson = new Gson();
	    	JsonObject job = gson.fromJson(response, JsonObject.class);
	    	JsonElement tempElement = job.getAsJsonObject("main").get("temp");
	    	if(tempElement != null 
	    			&& StringUtils.isNotEmpty(tempElement.toString())) {
	    		Double temp = Double.parseDouble(tempElement.toString()) - 273;
	    		DecimalFormat df=new DecimalFormat("0.00");
	    		String tempStr = df.format(temp);
	    		finalTemp = Double.parseDouble(tempStr) ;
	    	} else {
	    		System.out.println("Temp not found for City: " + pojo.getCity());
	    	}
	    	System.out.println(finalTemp);
	      } catch (Exception e) {
	            e.printStackTrace();
	    }
	    return finalTemp;
	 }

}
