package com.salesianostriana.e07_modelosmanytomany.services;

import com.salesianostriana.e07_modelosmanytomany.models.AddedTo;
import com.salesianostriana.e07_modelosmanytomany.models.SongPlaylistPK;
import com.salesianostriana.e07_modelosmanytomany.repositories.AddedToRepository;
import com.salesianostriana.e07_modelosmanytomany.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AddedToService extends BaseService<AddedTo, SongPlaylistPK, AddedToRepository> {
}
