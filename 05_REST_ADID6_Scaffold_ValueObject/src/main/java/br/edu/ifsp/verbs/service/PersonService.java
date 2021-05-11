package br.edu.ifsp.verbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.verbs.converter.DozerConverter;
import br.edu.ifsp.verbs.data.models.Person;
import br.edu.ifsp.verbs.data.vo.PersonVO;
import br.edu.ifsp.verbs.exception.ResourceNotFoundException;
import br.edu.ifsp.verbs.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		this.findById(id);
		repository.deleteById(id);
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado na base de dados"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO update(Long id, PersonVO person) {
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Não encontramos registros para este ID."));
		
		entity.setId(id);
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
}
