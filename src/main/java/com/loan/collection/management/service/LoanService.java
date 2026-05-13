package com.loan.collection.management.service;

import com.loan.collection.management.dao.LoanDAO;
import com.loan.collection.management.model.Loan;
import com.loan.collection.management.model.LoanStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    @Autowired
    private LoanDAO loanDAO;

    public Loan createLoan(Loan loan) {

        loan.setStatus(LoanStatus.ACTIVE);
        loan.setCreatedAt(LocalDateTime.now());

        if (loan.getDiscount() == null) {
            loan.setDiscount(BigDecimal.ZERO);
        }

        return loanDAO.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanDAO.findAll();
    }

    public Loan getLoanById(UUID id) {
        return loanDAO.findById(id);
    }

    public Loan updateLoan(UUID id, Loan loan) {

        Loan existing = loanDAO.findById(id);

        if (existing != null) {
            existing.setLoanAmount(loan.getLoanAmount());
            existing.setPrincipalAmount(loan.getPrincipalAmount());
            existing.setDiscount(loan.getDiscount());
            existing.setStatus(loan.getStatus());

            return loanDAO.save(existing);
        }

        return null;
    }

    public void deleteLoan(UUID id) {
        loanDAO.delete(id);
    }
}