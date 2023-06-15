package com.exame.spotfree.services.impl;

import com.exame.spotfree.models.Music;
import com.exame.spotfree.repositorys.MusicRepository;
import com.exame.spotfree.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    private final MusicRepository musicRepository;
    @Override
    public Music getOne(Long id) {
        return musicRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Music> getAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music create(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public void delete(Long id) {
        Music music = musicRepository.findById(id).orElseThrow();
        musicRepository.delete(music);
    }
}
