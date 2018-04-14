package com.kevin.tabbookmark.model;

import javax.persistence.*;

@Entity(name = "Bookmark")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="song_name")
    private String songName;

    @Column(name="artist_name")
    private String artistName;

    @Column(name="link")
    private String link;

    public Bookmark() {
    }

    public Bookmark(String songName, String artistName, String link) {
        this.songName = songName;
        this.artistName = artistName;
        this.link = link;
    }

//Getter and Setter methods


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}