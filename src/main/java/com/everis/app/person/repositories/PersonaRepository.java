package com.everis.app.person.repositories;

import org.springframework.data.repository.CrudRepository;

import com.everis.app.person.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{

}
