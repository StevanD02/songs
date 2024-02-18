package com.example.stevan.controller;

import com.example.stevan.model.Songs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class SongsController {

    @GetMapping("/songs")
    public String getSongs(Model model){
        // Get songs from the database and add them to the model
        model.addAttribute("songs", Songs.getInstance().getSongs());
        return "songlistjs"; // assuming "songs" is the name of your Thymeleaf template
    }

    @PostMapping("/removeSong/{id}")
    public String removeSong(UUID uuid, @PathVariable String id){
        // Remove song from the database
        UUID songId = UUID.fromString(id);
        Songs.getInstance().removeSong(songId);
        return "redirect:/songs";
    }

}
