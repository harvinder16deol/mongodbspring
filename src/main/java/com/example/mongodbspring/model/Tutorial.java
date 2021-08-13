package com.example.mongodbspring.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection =  "tutorials")
public class Tutorial {

    @Id
    private  String id;
    private  String title;
    private  String description;

    public Tutorial(){

    }

    public Tutorial(String title,String description){
        this.title = title;
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + "]";
    }
}
