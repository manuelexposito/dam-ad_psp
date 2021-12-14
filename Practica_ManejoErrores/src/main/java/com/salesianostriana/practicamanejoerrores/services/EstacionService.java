package com.salesianostriana.practicamanejoerrores.services;

import com.salesianostriana.practicamanejoerrores.errors.exceptions.ListEntitiesNotFoundException;
import com.salesianostriana.practicamanejoerrores.errors.exceptions.SingleEntityNotFoundException;
import com.salesianostriana.practicamanejoerrores.models.CreateEstacionDto;
import com.salesianostriana.practicamanejoerrores.models.Estacion;
import com.salesianostriana.practicamanejoerrores.models.EstacionDtoConverter;
import com.salesianostriana.practicamanejoerrores.models.GetEstacionDto;
import com.salesianostriana.practicamanejoerrores.repositories.EstacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionService {

    @Autowired
    private EstacionRepository repository;

    public Estacion findById(Long id){

        Optional<Estacion> estacion = repository.findById(id);

        if (estacion.isEmpty()){
            throw new SingleEntityNotFoundException(Estacion.class, id);
        }else{
            return estacion.get();
        }

    }

    public List<Estacion> findAll(){

        //return repository.findAll();
        List<Estacion> lista = repository.findAll();

        if(lista.isEmpty()){
            throw new ListEntitiesNotFoundException(GetEstacionDto.class);
        } else{
            return lista;
        }

    }

    public Estacion save(Estacion e){
        return repository.save(e);
    }


    public Estacion save(CreateEstacionDto dto, EstacionDtoConverter converter){

        return repository.save((Estacion) converter.convertToEstacion(dto));

    }

    public Estacion edit(Estacion e, CreateEstacionDto dto){

        e.setNombre(dto.getNombre());
        e.setMarca(dto.getMarca());
        e.setServicios(dto.getServicios());
        e.setUbicacion(dto.getUbicacion());
        e.setTieneAutolavado(dto.isTieneAutolavado());
        e.setPrecioGasoilEspecial(dto.getPrecioGasoilEspecial());
        e.setPrecioGasoilNormal(dto.getPrecioGasoilNormal());
        e.setPrecioGasolina95Octanos(dto.getPrecioGasolina95Octanos());
        e.setPrecioGasolina98(dto.getPrecioGasolina98());
        e.setFechaApertura(dto.getFechaApertura());
        return save(e);
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
