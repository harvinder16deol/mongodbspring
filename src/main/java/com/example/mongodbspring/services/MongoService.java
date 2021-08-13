package com.example.mongodbspring.services;


import com.example.mongodbspring.model.Tutorial;
import com.example.mongodbspring.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoService {

    @Autowired
    private TutorialRepository tutrepo;

    public List<Tutorial> getalltut() {
        return tutrepo.findAll();
    }

    public Tutorial maketut(Tutorial tutorial) {
        return tutrepo.save(tutorial);
    }

    public Optional<Tutorial> gettut(String id) {
        return tutrepo.findById(id);
    }

    public Tutorial updatetut(String id, Tutorial tutorial) {
        Optional<Tutorial> gettutorial = tutrepo.findById(id);
        Tutorial updatedTutorial = gettutorial.get();
        updatedTutorial.setTitle(tutorial.getTitle());
        updatedTutorial.setDescription(tutorial.getDescription());
        return tutrepo.save(updatedTutorial);
    }

    public void deletetut(String id) {
        tutrepo.deleteById(id);
        return;
    }
}
