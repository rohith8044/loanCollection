package com.loan.collection.management.controller;

import com.loan.collection.management.model.CashTransactions;
import com.loan.collection.management.service.CashTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cash-transactions")
public class CashTransactionsController {

    @Autowired
    private CashTransactionsService service;

    // CREATE
    @PostMapping
    public CashTransactions create(@RequestBody CashTransactions tx) {
        return service.create(tx);
    }

    // GET ALL
    @GetMapping
    public List<CashTransactions> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CashTransactions getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CashTransactions update(@PathVariable UUID id,
                                  @RequestBody CashTransactions tx) {
        return service.update(id, tx);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}