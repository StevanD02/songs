package com.example.stevan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class SongRequest {
    UUID id;
    String songName;
    String artistName;
    String thumbnailUrl;

    public SongRequest(){
        this.id = UUID.randomUUID();
    }

}
