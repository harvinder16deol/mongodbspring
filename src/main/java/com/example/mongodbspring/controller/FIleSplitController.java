package com.example.mongodbspring.controller;


import com.example.mongodbspring.services.SplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class FIleSplitController {

    @Autowired
    private SplitService splitService;

    @GetMapping(value = "/splitfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> splitfile(@RequestParam("files") MultipartFile file) throws InterruptedException, IOException {
    splitService.split(file);
    return new ResponseEntity<>(true, HttpStatus.OK);
    }


}


