package com.elasticsearch.git.elasticdemoqueries.controller;

import com.elasticsearch.git.elasticdemoqueries.entity.User;
import com.elasticsearch.git.elasticdemoqueries.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultController {

    @Autowired
    UserRepository repository;

    @GetMapping("/get")
    public Iterable<User> getAll(){
        return repository.findAll();
    }

}
