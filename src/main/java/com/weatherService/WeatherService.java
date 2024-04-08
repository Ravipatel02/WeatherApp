package com.weatherService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

	  private final RestTemplate restTemplate;

	    public WeatherService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

    public String getForecastSummaryByLocationName(String cityName) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "223d59d9c1msh965c0a8e42a84efp1a1223jsndb80a954d892");
        headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+cityName+"/summary/",
                HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getHourlyForecastByLocationName(String cityName) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
        		"https://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&appid=429bcdfc2cd3d075f0f369a6379f8906",
                HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}

