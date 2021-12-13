package com.salesianostriana.practicamanejoerrores.services;

import com.salesianostriana.practicamanejoerrores.models.CreateEstacionDto;
import com.salesianostriana.practicamanejoerrores.models.EstacionDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionService<Estacion, Long, EstacionRepository extends JpaRepository<Estacion, Long>>{

    @Autowired
    private EstacionRepository repository;

    public Optional<Estacion> findById(Long id){

        return repository.findById(id);
    }

    public List<Estacion> findAll(){
        return repository.findAll();
    }

    public Estacion save(Estacion e){
        return repository.save(e);
    }

    public Estacion save(CreateEstacionDto dto, EstacionDtoConverter converter){

        //return (Estacion) converter.convertToEstacion(dto);
        return repository.save((Estacion) converter.convertToEstacion(dto));

    }


    public Estacion edit(Estacion e){
        return save(e);
    }

    public void delete(Estacion e){
        repository.delete(e);
    }

    public List<Estacion> saveAll(List<Estacion> list){

        return repository.saveAll(list);

    }



}
