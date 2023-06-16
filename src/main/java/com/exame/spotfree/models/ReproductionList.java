package com.exame.spotfree.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ReproductionList {

    public ReproductionList(String name, String description, List<Music> musics) {
        this.name = name;
        this.description = description;
        this.musics = musics;
    }

    public ReproductionList() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
        name = "reproduction_list_music",
        joinColumns = @JoinColumn(name = "reproduction_list_id"),
        inverseJoinColumns = @JoinColumn(name = "music_id"))
    List<Music> musics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }


    public static class Builder {

        public  String name;

        public  String description;

        public List<Music> musics;

        public ReproductionList.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public ReproductionList.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ReproductionList.Builder withMusics(List<Music> musics){
            this.musics = musics;
            return this;
        }

        public ReproductionList build(){
            return new ReproductionList(name, description, musics);
        }
    }
}
