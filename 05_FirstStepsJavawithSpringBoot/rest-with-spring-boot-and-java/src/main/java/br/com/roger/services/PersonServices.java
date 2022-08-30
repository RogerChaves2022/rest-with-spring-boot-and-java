package br.com.roger.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.roger.exceptions.ResourceNotFoundException;
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
		
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating one Person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person!");
		
		var entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		
		return repository.save(person);
	}
	
	public void  delete(Long id) {
		logger.info("Delete one Person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records Found for this ID!"));
		repository.delete(entity);
		}
	
	
}
