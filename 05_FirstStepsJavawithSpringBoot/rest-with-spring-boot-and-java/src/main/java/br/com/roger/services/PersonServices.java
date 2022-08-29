package br.com.roger.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.roger.model.Person;
import br.com.roger.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		return repository.findAll();
	}
	

	public Person findById(Long id) {
		
		logger.info("Finding one Person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Roger");
		person.setLastName("Chaves");
		person.setAddress("Porto Alegre - Rio grande do sul - Brasil");
		person.setGender("Male");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating one Person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person!");
		Person entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return repository.save(person);
	}
	
	public void  delete(String id) {
		logger.info("Delete one Person!");
		}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name; " + i);
		person.setLastName("Last name; " + i);
		person.setAddress("Adress in Brasil; " + i);
		person.setGender("Male");
		return person;
	}
}
