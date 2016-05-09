package com.service;

import com.model.Weather;

import junit.framework.TestCase;

public class TestFetchWeatherService extends TestCase {

	public final void testGetWeather() {
		FetchWeatherService service = new FetchWeatherService();
		Weather pojo = new Weather();
		pojo.setCity("Sydney");
		pojo.setCountry("aus");
		pojo.setWeatherURL("http://api.openweathermap.org/data/2.5/weather?q=#,@&appid=008d10a1d28bbac61f0bcff204c3b573");
		Double temp = service.getWeather(pojo);
		assertTrue(temp != 0.0);
	}

}
