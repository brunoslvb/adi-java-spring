package br.edu.ifsp.verbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.edu.ifsp.verbs.models.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Bruno");
		person.setLastName("Barros");
		person.setAddress("Avenida Salgado Filho, 3501 - Vila Rio de Janeiro");
		person.setGender("Male");
		
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		
		for(int i = 0; i < 10; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}
	
	public Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Nome " + i);
		person.setLastName("Sobrenome " + i);
		person.setAddress("Endereço " + i);
		person.setGender("Male");
		
		return person;
	}
	
}
