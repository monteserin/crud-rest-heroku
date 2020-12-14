package com.pablomonteserin.prueba.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.pablomonteserin.prueba.persistence.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}