package com.salesianostriana.e07_modelosmanytomany.repositories;

import com.salesianostriana.e07_modelosmanytomany.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
