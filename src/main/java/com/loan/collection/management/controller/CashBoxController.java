package com.loan.collection.management.controller;

import com.loan.collection.management.model.CashBox;
import com.loan.collection.management.service.CashBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cashbox")
public class CashBoxController {

    @Autowired
    private CashBoxService cashBoxService;

    // CREATE
    @PostMapping
    public CashBox create(@RequestBody CashBox cashBox) {
        return cashBoxService.createCashBox(cashBox);
    }

    // GET ALL
    @GetMapping
    public List<CashBox> getAll() {
        return cashBoxService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CashBox getById(@PathVariable UUID id) {
        return cashBoxService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CashBox update(@PathVariable UUID id, @RequestBody CashBox cashBox) {
        return cashBoxService.update(id, cashBox);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        return cashBoxService.delete(id);
    }
}