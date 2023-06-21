package com.exame.spotfree.services.impl;

import com.exame.spotfree.constants.Genre;
import com.exame.spotfree.models.Music;
import com.exame.spotfree.repositorys.MusicRepository;
import com.exame.spotfree.repositorys.ReproductionListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class MusicServiceImplTest {

    @InjectMocks
    MusicServiceImpl musicService;

    @Mock
    MusicRepository musicRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("tryDeleteNonexistentMusicID")
    void testDeleteNonexistentMusicID() {

        assertThrows(NoSuchElementException.class, ()->
                musicService.delete(anyLong())
        );
    }

    @Test
    @DisplayName("tryCreateMusicAndReturnIt")
    void testCreateMusic() {

        Music music = new Music.Builder()
                .withAlbum(anyString())
                .withArtist("exemplo")
                .withGenre(Genre.CLASSIC)
                .withTitle("exemplo")
                .withYear(2022)
                .build();


        when(musicService.create(music)).thenReturn(music);
    }

    @Test
    @DisplayName("tryUpdatedANonexistentMusic")
    void testUpdateNonexistentMusic() {

        Music music = new Music.Builder()
                .withAlbum(anyString())
                .withArtist("exemplo")
                .withGenre(Genre.CLASSIC)
                .withTitle("exemplo")
                .withYear(2022)
                .build();

        assertThrows(NoSuchElementException.class, ()->
                musicService.update(1L, music)
        );
    }
}