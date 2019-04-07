package com.javacodegeeks.example.controller;

import com.javacodegeeks.example.model.Person;
import com.javacodegeeks.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final Logger LOG = LoggerFactory.getLogger(getClass().getName());

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        LOG.info("Saving Person: {}.", person);
        personRepository.save(person);
        LOG.info("Person saved: {}.", person);
        return person;
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long personId) {
        Person person = personRepository.findOne(personId);
    	/*Person person = new Person();
    	person.setId(1L);
    	person.setAge(34);
    	person.setName("Sanku");
        LOG.info("Got person from DB: {}.", person);*/
        return person;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> getAllPerson() {
        List<Person> persons = personRepository.findAll();
        LOG.info("Getting all Data: {}.", persons);
        return persons;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Person editPerson(@RequestBody Person person) {
        LOG.info("Updating Person: {}.", person);
        personRepository.save(person);
        LOG.info("Person updated: {}.", person);
        return person;
    }
    
    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long personId) {
        LOG.info("Deleting Person with ID {}.", personId);
        personRepository.delete(personId);
        LOG.info("Person deleted.");
    }
}
