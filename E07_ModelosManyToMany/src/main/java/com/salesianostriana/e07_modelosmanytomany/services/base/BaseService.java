package com.salesianostriana.e07_modelosmanytomany.services.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>>{

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
