package com.codeacademy.backend.http.weather;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApi {

    private RestTemplateBuilder restTemplateBuilder;

    public WeatherApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String getWeatherJson() {
        return getClient().getForObject("/weather?q=vilnius,lt&appid=658ffcb3d43159447f37482eb271c507", String.class);
    }

    private RestTemplate getClient() {
        return restTemplateBuilder
                .rootUri("http://api.openweathermap.org/data/2.5")
                .build();
    }
}
