package com.exame.spotfree.services.impl;

import com.exame.spotfree.models.Music;
import com.exame.spotfree.models.ReproductionList;
import com.exame.spotfree.models.request.ReproductionListRequest;
import com.exame.spotfree.repositorys.MusicRepository;
import com.exame.spotfree.repositorys.ReproductionListRepository;
import com.exame.spotfree.services.ReproductionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.exame.spotfree.validators.Validators.isEmptyList;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReproductionListServiceImpl implements ReproductionListService {

    @Autowired
    public ReproductionListServiceImpl(ReproductionListRepository reproductionListRepository, MusicRepository musicRepository) {
        this.reproductionListRepository = reproductionListRepository;
        this.musicRepository = musicRepository;
    }

    private final ReproductionListRepository reproductionListRepository;

    private final MusicRepository musicRepository;

    @Override
    public ReproductionList getOne(Long id) {
        return reproductionListRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ReproductionList> getAll() {
        return reproductionListRepository.findAll();
    }

    @Override
    public List<ReproductionList> getByName(String name) {
        List<ReproductionList> reproductionLists = reproductionListRepository.findByNameContaining(name);
        isEmptyList("No one reproduction list found" , reproductionLists);
        return reproductionLists;
    }

    @Override
    public ReproductionList create(ReproductionListRequest reproductionList) {

        List<Music> musics = new ArrayList<>();

        reproductionList.getMusicIds().forEach( music -> {
            Optional<Music> currentMusic = musicRepository.findById(Long.valueOf(music));
            musics.add(currentMusic.orElseThrow(NoSuchElementException::new));
        });

        return reproductionListRepository.save(
                new ReproductionList.Builder()
                        .withDescription(reproductionList.getDescription())
                        .withName(reproductionList.getName())
                        .withMusics(musics)
                        .build()
        );

    }

    @Override
    public void delete(Long id) {
        ReproductionList reproductionList = reproductionListRepository.findById(id).orElseThrow();
        reproductionListRepository.delete(reproductionList);
    }

    @Override
    public void deleteByName(String name) {
        ReproductionList reproductionList = reproductionListRepository.findByName(name).orElseThrow(NoSuchElementException::new);
        reproductionListRepository.delete(reproductionList);
    }

    @Override
    public ReproductionList update(Long id, ReproductionListRequest updatedReproductionList)  {
        ReproductionList reproductionList = reproductionListRepository.findById(id).orElseThrow();

        List<Music> musics = new ArrayList<>();

        updatedReproductionList.getMusicIds().forEach( music -> {
            Optional<Music> currentMusic = musicRepository.findById(Long.valueOf(music));
            musics.add(currentMusic.orElseThrow(NoSuchElementException::new));
        });

        reproductionList.setDescription(updatedReproductionList.getDescription());
        reproductionList.setName(updatedReproductionList.getDescription());
        reproductionList.setMusics(musics);
        reproductionList.setId(id);

        return reproductionListRepository.save(reproductionList);
    }
}
