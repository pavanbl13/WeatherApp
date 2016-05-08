package com.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Weather;
import com.service.FetchWeatherService;

@Controller
public class FormController {

	 @Autowired
	 FetchWeatherService weatherService;
	 @Autowired
	 Weather pojo;
	 
	 @Value("${country}")
	 private String country;
	 
	 @Value("${URL}")
	 private String weatherURL;
	 
	 @ModelAttribute("cityList")
		public ArrayList<String> loadCities() {
		 String [] cityArr = pojo.getCities().split(",");
		 System.out.println("Cities: "+ pojo.getCities());
		 ArrayList<String> cityList =  new ArrayList<String>(Arrays.asList(cityArr));
		 return cityList;
	 }
	@RequestMapping("/tests")
	public ModelAndView getList() {

		return new ModelAndView("test", "command", new Weather());
	}
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	
	public ModelAndView submitForm(@ModelAttribute("Weather")
    Weather pojo, BindingResult result)
					throws Exception {
		pojo.setCountry(country);
		pojo.setWeatherURL(weatherURL);
		Double temp = weatherService.getWeather(pojo);
		return new ModelAndView("success","temp",temp);
	}
}
