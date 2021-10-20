package com.salesianostriana.Apuntes_Service.service;

import com.salesianostriana.Apuntes_Service.model.Asignatura;
import com.salesianostriana.Apuntes_Service.repositories.AsignaturaRepository;
import com.salesianostriana.Apuntes_Service.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsignaturaService extends BaseService<Asignatura, Long, AsignaturaRepository> {

    public List<Asignatura> saveAll(List<Asignatura> list){

       return this.repositorio.saveAll(list);

    }

}
