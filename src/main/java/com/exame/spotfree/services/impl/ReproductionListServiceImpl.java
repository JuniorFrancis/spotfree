package com.exame.spotfree.services.impl;

import com.exame.spotfree.models.Music;
import com.exame.spotfree.models.ReproductionList;
import com.exame.spotfree.models.request.ReprodutionListRequest;
import com.exame.spotfree.repositorys.MusicRepository;
import com.exame.spotfree.repositorys.ReproductionListRepository;
import com.exame.spotfree.services.ReproductionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public ReproductionList getByName(String name) {
        return reproductionListRepository.findByName(name);
    }

    @Override
    public ReproductionList create(ReprodutionListRequest reproductionList){

        List<Music> musics = new ArrayList<>();

        reproductionList.getMusicIds().forEach( music -> {
            Optional<Music> currentMusic = musicRepository.findById(Long.valueOf(music));
            musics.add(currentMusic.orElseThrow());
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
        ReproductionList reproductionList = reproductionListRepository.findByName(name);
        reproductionListRepository.delete(reproductionList);
    }
}
