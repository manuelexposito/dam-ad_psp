package com.salesianostriana.e07_modelosmanytomany.repositories;

import com.salesianostriana.e07_modelosmanytomany.models.AddedTo;
import com.salesianostriana.e07_modelosmanytomany.models.SongPlaylistPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedToRepository extends JpaRepository<AddedTo, SongPlaylistPK> {
}
