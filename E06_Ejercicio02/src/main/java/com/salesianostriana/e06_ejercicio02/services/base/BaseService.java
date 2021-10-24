package com.salesianostriana.e06_ejercicio02.services.base;

import com.salesianostriana.e06_ejercicio02.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

    @Autowired
    protected R repository;


    public T save(T t){
        return repository.save(t);
    }

    public Optional<T> findById(ID id){

        return repository.findById(id);
    }


    public List<T> findAll(){

        return repository.findAll();
    }

    public T edit(T t){

        return repository.save(t);
    }

    public void delete(T t){

        repository.delete(t);
    }

    public void deleteById(ID id){

        repository.deleteById(id);
    }

    public List<T> saveAll(List<T> list){

        return repository.saveAll(list);
    }



}
