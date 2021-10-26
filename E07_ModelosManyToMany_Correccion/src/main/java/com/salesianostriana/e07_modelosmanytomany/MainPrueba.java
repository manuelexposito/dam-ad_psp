package com.salesianostriana.e07_modelosmanytomany;

import com.salesianostriana.e07_modelosmanytomany.models.AddedTo;
import com.salesianostriana.e07_modelosmanytomany.models.Artist;
import com.salesianostriana.e07_modelosmanytomany.models.Playlist;
import com.salesianostriana.e07_modelosmanytomany.models.Song;
import com.salesianostriana.e07_modelosmanytomany.repositories.AddedToRepository;
import com.salesianostriana.e07_modelosmanytomany.services.AddedToService;
import com.salesianostriana.e07_modelosmanytomany.services.ArtistService;
import com.salesianostriana.e07_modelosmanytomany.services.PlaylistService;
import com.salesianostriana.e07_modelosmanytomany.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final ArtistService artistService;
    private final SongService songService;
    private final PlaylistService playlistService;
    private final AddedToService addedToService;


    @PostConstruct
    public void test(){

    Artist a = Artist.builder()
            .name("Lil Nas X")
            .build();

    Song s = Song.builder()
            .title("Industry baby")
            .album("Montero")
            .year("2021").build();



    songService.save(s);

    artistService.save(a);

        s.addSongToArtist(a);
        artistService.edit(a);
        songService.edit(s);

    //Crear playlist y probar
/*
    Playlist pl = Playlist.builder()
            .name("Playlist de prueba")
            .description("Playlist para meter canciones bien perronas")
            .build();

    playlistService.save(pl);

    AddedTo addSong = AddedTo.builder().build();

    addSong.addToPlaylist(pl);
    addSong.addPlaylistToSong(s);
    addedToService.save(addSong);

*/
}

}

