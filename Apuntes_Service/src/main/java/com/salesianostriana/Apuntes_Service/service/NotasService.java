package com.salesianostriana.Apuntes_Service.service;

import com.salesianostriana.Apuntes_Service.model.Alumno;
import com.salesianostriana.Apuntes_Service.model.Curso;
import com.salesianostriana.Apuntes_Service.model.Notas;
import com.salesianostriana.Apuntes_Service.model.NotasPK;
import com.salesianostriana.Apuntes_Service.repositories.NotasRepository;
import com.salesianostriana.Apuntes_Service.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class NotasService extends BaseService<Notas, NotasPK, NotasRepository> {


    public Alumno matriculaCurso(Alumno a, Curso c){

        c.getAsignaturas().forEach( asignatura -> {
            Notas n = Notas.builder()
                    .alumno(a)
                    .asignatura(asignatura).build();
            save(n);
        });

        return a;
    }


}
