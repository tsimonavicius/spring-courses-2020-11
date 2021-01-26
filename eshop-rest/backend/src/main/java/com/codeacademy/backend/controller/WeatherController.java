package com.codeacademy.backend.controller;

import com.codeacademy.backend.controller.dto.LocationDTO;
import com.codeacademy.backend.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/location")
    public LocationDTO getWeatherLocation() {
        return weatherService.getWeatherLocation();
    }
}
