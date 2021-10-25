package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class SongPlaylistPK implements Serializable {

    private Long songId;

    private Long playlistId;

}
