package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@EntityListeners(AuditingEntityListener.class)
public class AddedTo implements Serializable {

    @Builder.Default
    @EmbeddedId
    private SongPlaylistPK id = new SongPlaylistPK();

    @CreatedDate
    private LocalDateTime dateTime;

    @Builder.Default
    private int orden = 0;

    @ManyToOne
    @MapsId("song_id")
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;


    //HELPERS

    //añade la canción a la playlist
    public void addToPlaylist(Playlist pl){

        this.setPlaylist(pl);
        pl.getSongsAdded().add(this);

    }

    public void removeFromPlaylist(Playlist pl){

        this.setPlaylist(null);
        pl.getSongsAdded().remove(this);
    }

    //añade a la canción la playlist a la que pertenece
    public void addPlaylistToSong(Song s){

        this.setSong(s);
        s.getAddedToPlaylist().add(this);

    }

    public void removePlaylistFromSong(Song s){

        this.setSong(null);
        s.getAddedToPlaylist().remove(s);
    }

}
