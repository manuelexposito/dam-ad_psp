package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "artist")
    private List<Song> songs = new ArrayList<>();


    //HELPERS
    /*
    public void addSongToArtist(Song s){
        this.getSongs().add(s);
        s.setArtist(this);
    }

    public void removeSongFromArtist(Song s){
        this.getSongs().remove(s);
        s.setArtist(null);

    }
*/

}
