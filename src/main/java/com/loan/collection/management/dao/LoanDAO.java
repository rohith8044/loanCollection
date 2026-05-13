package com.loan.collection.management.dao;

import com.loan.collection.management.model.Loan;
import com.loan.collection.management.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class LoanDAO {

    @Autowired
    private LoanRepository loanRepository;

    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public Loan findById(UUID id) {
        return loanRepository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        loanRepository.deleteById(id);
    }
}
