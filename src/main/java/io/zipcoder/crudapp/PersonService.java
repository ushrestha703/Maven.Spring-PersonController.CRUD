package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    public Person getPerson(int id){
        return personRepository.findOne(id);
    }

    public Iterable<Person> getPersonList(){
        return personRepository.findAll();

    }

    public Person createPerson(Person p){
        return personRepository.save(p);
    }

    public Person updatePerson(Person p, Integer id){
        Person updatedPerson = personRepository.findOne(id);
        updatedPerson.setFirstName( p.getFirstName());
        updatedPerson.setLastName(p.getLastName());
        updatedPerson.setId(p.getId());
        return personRepository.save(updatedPerson);
    }

    public void deletePerson(int id){
        personRepository.delete(id);
    }


    public Person updatePersonFirstName(String firstName,Integer id){
        Person updatedPerson = personRepository.findOne(id);
        updatedPerson.setFirstName(firstName);
        return personRepository.save(updatedPerson);
    }
}
