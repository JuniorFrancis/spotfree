package com.exame.spotfree.controllers;

import com.exame.spotfree.models.Music;
import com.exame.spotfree.services.MusicService;
import com.exame.spotfree.services.impl.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/musics")
public class MusicController {

    @Autowired
    public MusicController(MusicServiceImpl musicService) {
        this.musicService = musicService;
    }

    private final MusicServiceImpl musicService;

    @GetMapping
    public List<Music> getAll(){
        return musicService.getAll();
    }

    @GetMapping("/{id}")
    public Music getOne(@PathVariable Long id){
        return musicService.getOne(id);
    }

    @PostMapping
    public Music create(@RequestBody Music music){
        return musicService.create(music);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        musicService.delete(id);
    }
}
