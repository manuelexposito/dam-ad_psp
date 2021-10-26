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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<AddedTo> songsAdded = new ArrayList<>();

    @Lob
    private String description;


}
