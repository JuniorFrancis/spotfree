package com.exame.spotfree.services;

import com.exame.spotfree.models.Music;

import java.util.List;

public interface MusicService {

    Music getOne(Long id);

    List<Music> getAll();

    Music create(Music music);

    void delete(Long id);

    Music update(Long id, Music updatedMusic) throws ClassNotFoundException;
}
