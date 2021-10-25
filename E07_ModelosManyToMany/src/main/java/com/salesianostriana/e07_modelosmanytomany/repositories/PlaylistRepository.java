package com.salesianostriana.e07_modelosmanytomany.repositories;

import com.salesianostriana.e07_modelosmanytomany.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
