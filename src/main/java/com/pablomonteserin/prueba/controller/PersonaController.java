package com.pablomonteserin.prueba.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pablomonteserin.prueba.persistence.model.Persona;
import com.pablomonteserin.prueba.persistence.repository.PersonaRepository;

@RestController
public class PersonaController {
	@Autowired
	private PersonaRepository personaRepository;

	@CrossOrigin
	@RequestMapping(path = "/createPersona", method = RequestMethod.POST)
	public void submit(@RequestBody Persona persona) throws IOException {
		personaRepository.save(persona);
	}
	
	@CrossOrigin
	@RequestMapping(path = "/getListPersonas", method = RequestMethod.GET)
	public Iterable<Persona> consultar() throws IOException {
		Iterable<Persona> personas = personaRepository.findAll();
		return personas;
	}
	
	@CrossOrigin
	@RequestMapping(path = "/removePersona", method = RequestMethod.DELETE)
	public void baja(@RequestBody Persona persona) throws IOException {
		personaRepository.delete(persona);
	}
	
	@CrossOrigin
	@RequestMapping(path = "/updatePersona", method = RequestMethod.PUT)
	public void update(@RequestBody Persona persona) throws IOException {
		personaRepository.save(persona);
	}
	@CrossOrigin(origins = "https://pablomonteserin.com")

	@RequestMapping(path = "/getPersonaById", method = RequestMethod.GET)
	public Optional<Persona> getPersonaById(@RequestParam(value="id") int id) throws IOException {
		Optional<Persona> p =  personaRepository.findById(id);
		return p;
	}

}
