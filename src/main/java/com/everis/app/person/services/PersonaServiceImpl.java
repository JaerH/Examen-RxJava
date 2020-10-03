package com.everis.app.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.app.person.entity.Persona;
import com.everis.app.person.repositories.PersonaRepository;

import io.reactivex.Maybe;
import io.reactivex.Observable;


@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	public Observable<Persona> findAll() {
	
			Observable<Persona> person = Observable.fromIterable(personaRepository.findAll())
					.map(persona ->{
						return persona;		
			});	
			return person;		
	}

	@Override
	@Transactional(readOnly = true)
	public Maybe<Persona> findByDni(Integer dni) {
		
		Maybe<Persona> persona = findAll().filter(l -> l.getDni().equals(dni)).firstElement();	
		
		return persona;
	}



	
	
	
	
	
	
	
	/*@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		
		return (List<Persona>) personaRepository.findAll();
	}*/
	
	

	/*@Override
	@Transactional(readOnly = true)
	public Persona findById(Long id) {
		
		return personaRepository.findById(id).orElse(null);
	}

	/*@Override
	@Transactional(readOnly = true)
	public List<Persona> findByDni(Integer dni){ 
		return findAll().stream().filter(l -> l.getDni().equals(dni)).collect(Collectors.toList());
	
	}*/



}
