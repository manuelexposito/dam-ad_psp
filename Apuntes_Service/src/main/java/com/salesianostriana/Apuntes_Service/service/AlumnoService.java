package com.salesianostriana.Apuntes_Service.service;

import com.salesianostriana.Apuntes_Service.model.Alumno;
import com.salesianostriana.Apuntes_Service.model.Curso;
import com.salesianostriana.Apuntes_Service.repositories.AlumnoRepository;
import com.salesianostriana.Apuntes_Service.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AlumnoService extends BaseService<Alumno, Long, AlumnoRepository> {


}
