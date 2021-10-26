package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class SongPlaylistPK implements Serializable {

    @Column(name = "song_id")
    private Long song_id;

    @Column(name = "playlist_id")
    private Long playlist_id;

}
