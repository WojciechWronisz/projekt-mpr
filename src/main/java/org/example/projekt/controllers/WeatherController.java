package org.example.projekt.controllers;

import lombok.RequiredArgsConstructor;
import org.example.projekt.services.ExternalWeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final ExternalWeatherService externalWeatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        return externalWeatherService.getWeather(city);
    }
}
