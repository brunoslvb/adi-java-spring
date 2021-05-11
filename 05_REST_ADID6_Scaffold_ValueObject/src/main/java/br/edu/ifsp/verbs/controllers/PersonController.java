package br.edu.ifsp.verbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.verbs.data.vo.PersonVO;
import br.edu.ifsp.verbs.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("")
	public List<PersonVO> findAll() {
		return personService.findAll();
	}
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return personService.findById(id);
	}
	
	@PostMapping("")
	public PersonVO save(@RequestBody PersonVO person) {
		return personService.create(person);
	}
	
	@PutMapping("/{id}")
	public PersonVO update(@PathVariable("id") Long id, @RequestBody PersonVO person) {
		return personService.update(id, person);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		personService.delete(id);
	}
	
}
