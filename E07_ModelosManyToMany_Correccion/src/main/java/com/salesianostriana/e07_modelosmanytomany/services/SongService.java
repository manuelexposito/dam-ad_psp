package com.salesianostriana.e07_modelosmanytomany.services;

import com.salesianostriana.e07_modelosmanytomany.models.Song;
import com.salesianostriana.e07_modelosmanytomany.repositories.SongRepository;
import com.salesianostriana.e07_modelosmanytomany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SongService extends BaseService<Song, Long, SongRepository> {
}
