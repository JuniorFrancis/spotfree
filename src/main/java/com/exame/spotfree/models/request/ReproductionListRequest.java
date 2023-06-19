package com.exame.spotfree.models.request;

import org.springframework.lang.NonNull;

import java.util.List;

public class ReproductionListRequest {

    public ReproductionListRequest(@NonNull String name, String description, List<Integer> musicIds) {
        this.name = name;
        this.description = description;
        this.musicIds = musicIds;
    }

    @NonNull
    private String name;

    private String description;

    private List<Integer> musicIds;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getMusicIds() {
        return musicIds;
    }

    public void setMusicIds(List<Integer> musicIds) {
        this.musicIds = musicIds;
    }
}
