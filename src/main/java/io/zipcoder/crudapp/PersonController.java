package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personService.createPerson(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @GetMapping("/people/all")
    public ResponseEntity<List<Person>> getPersonList(){
        return new ResponseEntity<>((List<Person>) personService.getPersonList(),HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public void  deletePerson(@PathVariable int id){
        personService.deletePerson(id);
    }

    @PutMapping("/people/updateFn/{id}")
    public ResponseEntity<Person> updateFirstName(@RequestParam  String firstName,@PathVariable Integer id){
        return new ResponseEntity<>(personService.updatePersonFirstName(firstName, id), HttpStatus.CREATED);
    }

}