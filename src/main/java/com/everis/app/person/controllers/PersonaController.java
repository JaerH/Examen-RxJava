package com.everis.app.person.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.app.person.entity.Persona;
import com.everis.app.person.services.IPersonaService;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/listar")
	
	public Observable<Persona> getAll(){
		
		return personaService.findAll();	
	}
	
	
	@GetMapping(path = "/info/{dni}")
	public Maybe<Persona> getDni(@PathVariable Integer dni) throws Exception{
		return personaService.findByDni(dni);

	
	}
	
}
