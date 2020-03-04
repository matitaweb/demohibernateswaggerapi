package com.example.demohibernateswaggerapi.controller;

import com.example.demohibernateswaggerapi.exception.CustomerNotFoundException;
import com.example.demohibernateswaggerapi.repository.CustomerRepository;
import com.example.demohibernateswaggerapi.model.Customer;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    @Autowired
    private CustomerRepository repository;

    @GetMapping("/{id}")
    public Customer findById(@PathVariable long id) {
        log.debug("research for id {}", id);
        return Optional.ofNullable(repository.findById(id))
                .orElseThrow(CustomerNotFoundException::new);
    }


    @GetMapping("/")
    public Collection<Customer> findAll() {
        Iterator<Customer> iterator = repository.findAll().iterator();
        List<Customer> list = new ArrayList<>();

        // Add each element of iterator to the List
        iterator.forEachRemaining(list::add);
        return list;
    }

    @PutMapping(value = "/{id}", consumes = {"application/json", "application/xml"})
    public Customer updateCustomer(@PathVariable("id") final String id, @RequestBody final Customer c) {
        log.debug("{}", c);
        c.setId(null);
        repository.save(c);
        return c;
    }
}
