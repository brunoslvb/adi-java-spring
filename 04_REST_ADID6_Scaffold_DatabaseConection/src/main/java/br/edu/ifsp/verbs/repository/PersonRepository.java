package br.edu.ifsp.verbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.verbs.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
