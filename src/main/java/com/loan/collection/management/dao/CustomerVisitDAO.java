package com.loan.collection.management.dao;

import com.loan.collection.management.model.CustomerVisit;
import com.loan.collection.management.repository.CustomerVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerVisitDAO {

    @Autowired
    private CustomerVisitRepository repository;

    public CustomerVisit save(CustomerVisit visit) {
        return repository.save(visit);
    }

    public List<CustomerVisit> findAll() {
        return repository.findAll();
    }

    public CustomerVisit findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}