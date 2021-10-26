package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Artist artist;

    @Builder.Default
    @OneToMany(mappedBy = "song")
    private List<AddedTo> addedToPlaylist = new ArrayList<>();


    private String title, album, year;

    //helpers

    public void addSongToArtist(Artist a){
        a.getSongs().add(this);
        this.setArtist(a);
    }

    public void removeSongFromArtist(Artist a){
        a.getSongs().remove(a);
        this.setArtist(null);

    }

}
