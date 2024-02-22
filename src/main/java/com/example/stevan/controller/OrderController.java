package com.example.stevan.controller;

import com.example.stevan.model.SongRequest;
import com.example.stevan.model.Songs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController{

    @GetMapping("/")
    public String redirect() {
        return "redirect:/order";
    }

    @GetMapping("/order")
    public String getOrder(Model model){
        model.addAttribute("songRequest", new SongRequest());
        return "order"; // assuming "order" is the name of your Thymeleaf template
    }

    @PostMapping("/order")
    public String submitOrder(SongRequest songRequest, Model model){
        // Do something with the song request
        Songs.getInstance().addSong(songRequest);
        model.addAttribute("songRequest", new SongRequest());
        return "order"; // assuming "order" is the name of your Thymeleaf template
    }
}
