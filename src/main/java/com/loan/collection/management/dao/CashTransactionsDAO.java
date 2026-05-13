package com.loan.collection.management.dao;

import com.loan.collection.management.model.CashTransactions;
import com.loan.collection.management.model.CashTransactions;
import com.loan.collection.management.repository.CashTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CashTransactionsDAO {

    @Autowired
    private CashTransactionsRepository repository;

    public CashTransactions save(CashTransactions tx) {
        return repository.save(tx);
    }

    public List<CashTransactions> findAll() {
        return repository.findAll();
    }

    public Optional<CashTransactions> findById(UUID id) {
        return repository.findById(id);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}