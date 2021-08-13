package com.example.mongodbspring.repository;

import com.example.mongodbspring.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorialRepository extends MongoRepository<Tutorial,String> {

}
