package com.salesianostriana.e07_modelosmanytomany.repositories;

import com.salesianostriana.e07_modelosmanytomany.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
