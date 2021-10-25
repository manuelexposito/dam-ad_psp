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
public class Playlist implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "playlist")
    private List<AddedTo> songsAdded = new ArrayList<>();

    @Lob
    private String description;


}
