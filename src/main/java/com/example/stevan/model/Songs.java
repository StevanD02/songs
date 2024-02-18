package com.example.stevan.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.UUID;

public class Songs {
    private static List<SongRequest> songs;
    private static Songs instance;

    private Songs(){
        songs = new ArrayList<>();
    }

    public static Songs getInstance(){
        if(instance == null){
            instance = new Songs();
        }
        return instance;
    }

    public void addSong(SongRequest song){
        songs.add(song);
        System.out.println(songs);
    }

    public void removeSong(SongRequest song){
        songs.remove(song);
    }

    public void removeSong(UUID uuid){
        for(SongRequest song : songs){
            if(song.getId().equals(uuid)){
                songs.remove(song);
                break;
            }
        }
    }

    public List<SongRequest> getSongs(){
        return songs;
    }
}
