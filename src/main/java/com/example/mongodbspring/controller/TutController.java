package com.example.mongodbspring.controller;


import com.example.mongodbspring.model.Tutorial;
import com.example.mongodbspring.repository.TutorialRepository;
import com.example.mongodbspring.services.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TutController {

    @Autowired
    private TutorialRepository tutrep;

    @Autowired
    private MongoService dbservice;

    @PostMapping(value="/new")
    public ResponseEntity<Tutorial> maketut(@RequestBody Tutorial tutorial){
        try{
            Tutorial tut = dbservice.maketut(tutorial);
            return new ResponseEntity<>(tut, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Tutorial>> getall() {
        try {
            List<Tutorial> tutorials = dbservice.getalltut();
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value="/get/{id}")
    public ResponseEntity<Tutorial> getTutorial(@PathVariable("id") String id){
        try{
            Optional<Tutorial> tutorial = dbservice.gettut(id);
            return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping(value="/update/{id}")
    public  ResponseEntity<Tutorial> updateTutorial(@PathVariable String id, @RequestBody Tutorial tutorial){
        try{
            Tutorial gettutorial = dbservice.updatetut(id,tutorial);
            return new ResponseEntity<>(gettutorial, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
        try {
            dbservice.deletetut(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/printall")
    public void printall(){
       List<Tutorial> tutorials = tutrep.findAll();
       if(tutorials.size() == 0){
           System.out.println("no data");
       }
       for(Tutorial tut: tutorials){
           System.out.println(tut.getTitle());

       }
    }

    @GetMapping(value = "/test")
    public String heello(){
        System.out.println("hii.. ");
        return "hii harry";
    }

}
