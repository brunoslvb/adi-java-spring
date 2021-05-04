package br.edu.ifsp.verbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.verbs.exception.ResourceNotFoundException;
import br.edu.ifsp.verbs.models.Person;
import br.edu.ifsp.verbs.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public void delete(Long id) {
		this.findById(id);
		repository.deleteById(id);
	}
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado na base de dados"));
	}
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person update(Long id, Person obj) {
		Person person = this.findById(id);
		person.setId(id);
		person.setFirstName(obj.getFirstName());
		person.setLastName(obj.getLastName());
		person.setAddress(obj.getAddress());
		person.setGender(obj.getGender());
		
		return repository.save(person);
	}
	
}
