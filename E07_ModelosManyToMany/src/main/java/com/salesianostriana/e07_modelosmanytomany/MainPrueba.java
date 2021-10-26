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
    Artist a2 = Artist.builder()
            .name("AJR")
            .build();


    Song s = Song.builder()
            .title("Industry baby")
            .album("Montero")
            .year("2021").build();

    Song s2 = Song.builder()
            .title("Bud like you")
            .album("Click")
            .year("2019").build();

    songService.save(s);
    songService.save(s2);

    artistService.save(a);
    artistService.save(a2);

        s.addSongToArtist(a);
        s2.addSongToArtist(a2);
        artistService.edit(a);
        songService.edit(s);

        artistService.edit(a2);
        songService.edit(s2);

    //Crear playlist y probar

    Playlist pl = Playlist.builder()
            .name("Playlist de prueba")
            .description("Playlist para meter canciones bien perronas")
            .build();

        Playlist pl2 = Playlist.builder()
                .name("Otra playlist")
                .description("Segunda playlist para ver si se conectan adecuadamente")
                .build();

    playlistService.save(pl);
    playlistService.save(pl2);



    addedToService.addSong(s2, pl);
    addedToService.addSong(s, pl2);


}

}

