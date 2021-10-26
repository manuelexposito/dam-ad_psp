package com.salesianostriana.e07_modelosmanytomany.services;

import com.salesianostriana.e07_modelosmanytomany.models.Artist;
import com.salesianostriana.e07_modelosmanytomany.repositories.ArtistRepository;
import com.salesianostriana.e07_modelosmanytomany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArtistService extends BaseService<Artist, Long, ArtistRepository> {
}
