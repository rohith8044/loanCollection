package com.loan.collection.management.dao;

import com.loan.collection.management.model.CashBox;
import com.loan.collection.management.repository.CashBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CashBoxDAO {

    @Autowired
    private CashBoxRepository repository;

    public CashBox save(CashBox cashBox) {
        return repository.save(cashBox);
    }

    public List<CashBox> findAll() {
        return repository.findAll();
    }

    public Optional<CashBox> findById(UUID id) {
        return repository.findById(id);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}