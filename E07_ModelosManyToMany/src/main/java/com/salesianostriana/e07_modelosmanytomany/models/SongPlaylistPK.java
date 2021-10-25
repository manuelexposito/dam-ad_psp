package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SongPlaylistPK {

    private Long songId;

    private Long playlistId;

}
