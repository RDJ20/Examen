package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entites.EntityCitas;

public interface RepositoryCitas extends CrudRepository<EntityCitas, Long> {

}
