package com.loan.collection.management.controller;

import com.loan.collection.management.model.CustomerVisit;
import com.loan.collection.management.service.CustomerVisitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/visits")
public class CustomerVisitController {

    @Autowired
    private CustomerVisitService service;

    @PostMapping
    public CustomerVisit createVisit(@RequestBody CustomerVisit visit) {
        return service.createVisit(visit);
    }

    @GetMapping
    public List<CustomerVisit> getAllVisits() {
        return service.getAllVisits();
    }

    @GetMapping("/{id}")
    public CustomerVisit getVisit(@PathVariable UUID id) {
        return service.getVisit(id);
    }

    @PutMapping("/{id}")
    public CustomerVisit updateVisit(@PathVariable UUID id,
                                     @RequestBody CustomerVisit visit) {
        return service.updateVisit(id, visit);
    }

    @DeleteMapping("/{id}")
    public String deleteVisit(@PathVariable UUID id) {
        service.deleteVisit(id);
        return "Deleted Successfully";
    }
}