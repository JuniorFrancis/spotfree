package com.exame.spotfree.models;

import com.exame.spotfree.constants.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Music {

    public Music(String title, String artist, String album, int year, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.genre = genre;
    }

    public Music() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String artist;

    private String album;

    private int year;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "musics"
    )
    @JsonIgnore
    List<ReproductionList> reproductionLists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public static class Builder {

        public String title;

        public String artist;

        public String album;

        public int year;

        public Genre genre;

        public Music.Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Music.Builder withArtist(String artist) {
            this.artist = artist;
            return this;
        }

        public Music.Builder withAlbum(String album){
            this.album = album;
            return this;
        }

        public Music.Builder withYear(int year){
            this.year = year;
            return this;
        }

        public Music.Builder withGenre(Genre genre){
            this.genre = genre;
            return this;
        }

        public Music build(){
            return new Music(title, artist, album, year, genre);
        }
    }
}
