package com.service;

import com.model.Weather;

import junit.framework.TestCase;

public class TestFetchWeatherService extends TestCase {

	public final void testGetWeather() {
		FetchWeatherService service = new FetchWeatherService();
		Weather pojo = new Weather();
		pojo.setCity("Sydney");
		pojo.setCountry("aus");
		service.getWeather(pojo);
	}

}
