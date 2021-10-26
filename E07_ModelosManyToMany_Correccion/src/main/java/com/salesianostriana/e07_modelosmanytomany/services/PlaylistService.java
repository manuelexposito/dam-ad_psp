package com.salesianostriana.e07_modelosmanytomany.services;

import com.salesianostriana.e07_modelosmanytomany.models.Playlist;
import com.salesianostriana.e07_modelosmanytomany.repositories.PlaylistRepository;
import com.salesianostriana.e07_modelosmanytomany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService extends BaseService<Playlist, Long, PlaylistRepository> {
}
