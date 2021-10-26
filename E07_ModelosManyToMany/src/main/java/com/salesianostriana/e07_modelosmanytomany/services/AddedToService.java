package com.salesianostriana.e07_modelosmanytomany.services;

import com.salesianostriana.e07_modelosmanytomany.models.AddedTo;
import com.salesianostriana.e07_modelosmanytomany.models.Playlist;
import com.salesianostriana.e07_modelosmanytomany.models.Song;
import com.salesianostriana.e07_modelosmanytomany.models.SongPlaylistPK;
import com.salesianostriana.e07_modelosmanytomany.repositories.AddedToRepository;
import com.salesianostriana.e07_modelosmanytomany.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddedToService extends BaseService<AddedTo, SongPlaylistPK, AddedToRepository> {


    public void addSong(Song s, Playlist pl){

        AddedTo songAdded = AddedTo.builder()
                .song(s)
                .playlist(pl)
                .dateTime(LocalDateTime.now())
                .build();

        pl.getSongsAdded().add(songAdded);
        s.getAddedToPlaylist().add(songAdded);

       this.save(songAdded);

    }


}
