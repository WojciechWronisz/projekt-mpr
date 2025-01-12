package org.example.projekt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ExternalWeatherService {

    private final WebClient webClient;

    public ExternalWeatherService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.weatherapi.com/v1")
                .build();
    }

    public String getWeather(String city) {
        String apiKey = "YOUR_API_KEY"; // Podmień na klucz API
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", city)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block(); // W przypadku aplikacji synchronicznej
    }
}
