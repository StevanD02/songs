package com.example.stevan.controller;

import com.example.stevan.model.SongRequest;
import com.example.stevan.model.Songs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongsRestController {
    // Assuming Songs.getInstance().getSongs() returns a List<Song>
    @GetMapping("/api/songs")
    public List<SongRequest> getSongs() {
        return Songs.getInstance().getSongs();
    }
}
