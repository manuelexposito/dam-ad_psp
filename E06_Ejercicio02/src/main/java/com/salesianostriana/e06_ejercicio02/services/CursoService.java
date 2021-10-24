package com.salesianostriana.e06_ejercicio02.services;

import com.salesianostriana.e06_ejercicio02.models.CursoOnline;
import com.salesianostriana.e06_ejercicio02.repositories.CursoRepository;
import com.salesianostriana.e06_ejercicio02.services.base.BaseService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService extends BaseService<CursoOnline, Long, CursoRepository> {


    @Override
    public List<CursoOnline> findAll(){
        return this.repository.findAllJoin();
    }



}
