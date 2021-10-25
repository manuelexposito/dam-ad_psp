package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;

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

    @OneToMany(mappedBy = "song")
    private List<AddedTo> addedToPlaylist = new ArrayList<>();


    private String title, album, year;

}
