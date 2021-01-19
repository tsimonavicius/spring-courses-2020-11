package com.codeacademy.backend.http.weather.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherPOJO {
    private Double temp;

    @JsonAlias("feels_like")
    private Double feelsLike;

    @JsonAlias("temp_min")
    private Double tempMin;

    @JsonAlias("temp_max")
    private Double tempMax;

    private Double humidity;
}
