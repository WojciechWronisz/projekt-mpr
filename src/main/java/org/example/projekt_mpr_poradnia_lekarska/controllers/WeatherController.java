package org.example.projekt_mpr_poradnia_lekarska.controllers;

import lombok.RequiredArgsConstructor;
import org.example.projekt_mpr_poradnia_lekarska.services.ExternalWeatherService;
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
