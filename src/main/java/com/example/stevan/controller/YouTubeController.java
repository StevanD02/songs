package com.example.stevan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class YouTubeController {
    private String apiKey = "AIzaSyBxB7aORf1JtuZg2bgMl0rDpSu4VvIBbfA";

    private static final String YOUTUBE_SEARCH_URL = "https://www.googleapis.com/youtube/v3/search";

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/youtubeSearch")
    public String youtubeSearch(@RequestParam("query") String query) {
        // Construct the URL with the query and API key
        String searchUrl = YOUTUBE_SEARCH_URL + "?part=snippet&type=video&maxResults=5&q=" + query + "&key=" + apiKey;

        // Make the GET request to YouTube Data API and return the response body
        ResponseEntity<String> response = restTemplate.getForEntity(searchUrl, String.class);

        return response.getBody();
    }

    @GetMapping("/deezerSearch")
    public ResponseEntity<String> deezerSearch(@RequestParam String query) {
        String url = "https://api.deezer.com/search?q=" + query;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(result);
    }

}

