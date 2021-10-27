package com.salesianostriana.e08_herencia.services.base;

import com.salesianostriana.e08_herencia.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

    @Autowired
    protected R repository;

    public List<T> findAll(){

        return repository.findAll();
    }

    public Optional<T> findById(ID id){

        return repository.findById(id);
    }

    public T save(T t){

        return repository.save(t);
    }

    public List<T> saveAll(List<T> list){
        return repository.saveAll(list);
    }

    public T edit(T t){

        return repository.save(t);
    }

    public void delete(T t){

        repository.delete(t);
    }




}
