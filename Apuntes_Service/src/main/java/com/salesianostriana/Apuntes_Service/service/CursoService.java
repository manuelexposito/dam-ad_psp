package com.salesianostriana.Apuntes_Service.service;

import com.salesianostriana.Apuntes_Service.model.Curso;
import com.salesianostriana.Apuntes_Service.repositories.CursoRepository;
import com.salesianostriana.Apuntes_Service.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CursoService extends BaseService<Curso, Long, CursoRepository> {
}
