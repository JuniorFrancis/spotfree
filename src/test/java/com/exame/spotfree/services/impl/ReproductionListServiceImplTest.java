package com.exame.spotfree.services.impl;

import com.exame.spotfree.models.ReproductionList;
import com.exame.spotfree.models.request.ReproductionListRequest;
import com.exame.spotfree.repositorys.MusicRepository;
import com.exame.spotfree.repositorys.ReproductionListRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class ReproductionListServiceImplTest {

    @InjectMocks
    ReproductionListServiceImpl reproductionListService;

    @Mock
    ReproductionListRepository reproductionListRepository;

    @Mock
    MusicRepository musicRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("tryDeleteNonexistentReproductionListName")
    void testDeleteByName() {

        assertThrows(NoSuchElementException.class, ()->
            reproductionListService.deleteByName(anyString())
        );
    }

    @Test
    @DisplayName("tryDeleteNonexistentReproductionListId")
    void testDeleteById() {

        assertThrows(NoSuchElementException.class, ()->
                reproductionListService.delete(anyLong())
        );
    }

    @Test
    @DisplayName("tryCreateReproductionListWithNonexistentMusicsIDS")
    void testCreateReproductionListWithInvalidMusicIds() {
        List<Integer> ids = List.of(1, 2);
        assertThrows(NoSuchElementException.class, ()->
                reproductionListService.create( new ReproductionListRequest("exemplo", "exemplo", ids))
        );
    }

}