package com.model;

import java.util.ArrayList;

public class Weather {
	private String city;
	private String cities;
	private ArrayList<String> cityList;
	private String weatherURL;
	private String country;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param name the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the cities
	 */
	public String getCities() {
		return cities;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(String cities) {
		this.cities = cities;
	}

	/**
	 * @return the cityList
	 */
	public ArrayList<String> getCityList() {
		return cityList;
	}

	/**
	 * @param cityList the cityList to set
	 */
	public void setCityList(ArrayList<String> cityList) {
		this.cityList = cityList;
	}

	/**
	 * @return the weatherURL
	 */
	public String getWeatherURL() {
		return weatherURL;
	}

	/**
	 * @param weatherURL the weatherURL to set
	 */
	public void setWeatherURL(String weatherURL) {
		this.weatherURL = weatherURL;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
