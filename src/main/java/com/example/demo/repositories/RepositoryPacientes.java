package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entites.EntityPacientes;

public interface RepositoryPacientes extends CrudRepository<EntityPacientes, Long> {

}
