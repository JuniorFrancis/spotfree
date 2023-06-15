package com.exame.spotfree.models;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
public class ReproductionList {

    public ReproductionList(String name, String description, List<Music> reproductionListMusics) {
        this.name = name;
        this.description = description;
        this.reproductionListMusics = reproductionListMusics;
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
    List<Music> reproductionListMusics;

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

    public List<Music> getReproductionListMusics() {
        return reproductionListMusics;
    }

    public void setReproductionListMusics(List<Music> reproductionListMusics) {
        this.reproductionListMusics = reproductionListMusics;
    }


    public static class Builder {

        public  String name;

        public  String description;

        public List<Music> reproductionListMusics;

        public ReproductionList.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public ReproductionList.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ReproductionList.Builder withMusics(List<Music> reproductionListMusics){
            this.reproductionListMusics = reproductionListMusics;
            return this;
        }

        public ReproductionList build(){
            return new ReproductionList(name, description, reproductionListMusics);
        }
    }
}
