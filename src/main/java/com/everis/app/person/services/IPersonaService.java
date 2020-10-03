package com.everis.app.person.services;

import com.everis.app.person.entity.Persona;
import io.reactivex.Maybe;
import io.reactivex.Observable;


public interface IPersonaService {
	
	public Observable<Persona> findAll();
	public Maybe<Persona> findByDni(Integer dni);

}
