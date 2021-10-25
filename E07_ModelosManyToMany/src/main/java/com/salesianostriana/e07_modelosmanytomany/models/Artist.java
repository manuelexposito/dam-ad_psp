package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artist implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "artist")
    private List<Song> songs = new ArrayList<>();


    //HELPERS

    public void addSongToArtist(Song s){
        this.getSongs().add(s);
        s.setArtist(this);
    }

    public void removeSongFromArtist(Song s){
        this.getSongs().remove(s);
        s.setArtist(null);


    }


}
