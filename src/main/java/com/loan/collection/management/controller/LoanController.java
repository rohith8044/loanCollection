package com.loan.collection.management.controller;


import com.loan.collection.management.model.Loan;
import com.loan.collection.management.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable UUID id) {
        return loanService.getLoanById(id);
    }

    @PutMapping("/{id}")
    public Loan updateLoan(@PathVariable UUID id, @RequestBody Loan loan) {
        return loanService.updateLoan(id, loan);
    }

    @DeleteMapping("/{id}")
    public String deleteLoan(@PathVariable UUID id) {
        loanService.deleteLoan(id);
        return "Deleted Successfully";
    }
}
