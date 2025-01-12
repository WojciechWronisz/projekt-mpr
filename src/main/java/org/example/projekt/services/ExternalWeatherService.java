package org.example.projekt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ExternalWeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.base-url}")
    private String baseUrl;

    private final WebClient.Builder webClientBuilder;

    public String getWeather(String city) {
        WebClient webClient = webClientBuilder
                .baseUrl(baseUrl)
                .build();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", city)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
