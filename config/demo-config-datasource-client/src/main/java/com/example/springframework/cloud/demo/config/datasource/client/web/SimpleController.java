package com.example.springframework.cloud.demo.config.datasource.client.web;

import com.example.springframework.cloud.demo.config.datasource.client.dao.PersonRepository;
import com.example.springframework.cloud.demo.config.datasource.client.entity.Person;
import com.example.springframework.cloud.demo.config.datasource.client.entity.User;
import com.example.springframework.cloud.demo.config.datasource.client.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        return "demo config datasource client";
    }

    @GetMapping("/consumer")
    public String consumer() {
        return "[ server port ] : " + serverPort;
    }

    @GetMapping("/consumer/person")
    public List<Person> consumerPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/consumer/user")
    public List<User> consumerUser() {
        return userRepository.findAll();
    }

}