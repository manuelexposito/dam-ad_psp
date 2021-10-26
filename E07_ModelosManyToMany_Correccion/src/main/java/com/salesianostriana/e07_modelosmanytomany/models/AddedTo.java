package com.salesianostriana.e07_modelosmanytomany.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class AddedTo implements Serializable {

    @EmbeddedId
    private SongPlaylistPK id = new SongPlaylistPK();

    private LocalDateTime dateTime;
    private int order;

    @ManyToOne
    @MapsId("songId")
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @MapsId("playlistId")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;


    //HELPERS

    //añade la canción a la playlist
    public void addToPlaylist(Playlist pl){

        this.playlist = pl;
        this.dateTime = LocalDateTime.now();
        pl.getSongsAdded().add(this);

    }

    public void removeFromPlaylist(Playlist pl){

        this.playlist = null;
        pl.getSongsAdded().remove(this);
    }

    //añade a la canción la playlist a la que pertenece
    public void addPlaylistToSong(Song s){

        this.song = s;
        s.getAddedToPlaylist().add(this);

    }

    public void removePlaylistFromSong(Song s){

        this.song = null;
        s.getAddedToPlaylist().remove(s);
    }

}
