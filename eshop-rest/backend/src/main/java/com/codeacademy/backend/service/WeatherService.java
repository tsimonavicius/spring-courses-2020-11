package com.codeacademy.backend.service;

import com.codeacademy.backend.http.weather.dto.WeatherPOJO;
import com.codeacademy.backend.http.weather.WeatherApi;
import com.codeacademy.backend.controller.dto.LocationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private WeatherApi weatherApi;
    private ObjectMapper objectMapper;

    public WeatherService(WeatherApi weatherApi, ObjectMapper objectMapper) {
        this.weatherApi = weatherApi;
        this.objectMapper = objectMapper;
    }

    public LocationDTO getWeatherLocation() {
        LocationDTO locationDTO = new LocationDTO();

        String json = weatherApi.getWeatherJson();

        ObjectNode root;
        try {
            root = objectMapper.readValue(json, ObjectNode.class);
            var coord = root.get("coord");

            locationDTO.setLongitude(coord.get("lon").asText());
            locationDTO.setLatitude(coord.get("lat").asText());
            locationDTO.setCity(root.get("name").asText());

            WeatherPOJO weather = objectMapper.readValue(root.get("main").toString(), WeatherPOJO.class);
            locationDTO.setWeather(weather);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // TODO: handle exception properly
        }

        return locationDTO;
    }
}
