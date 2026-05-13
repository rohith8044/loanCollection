package com.loan.collection.management.service;

import com.loan.collection.management.dao.CashTransactionsDAO;
import com.loan.collection.management.model.CashTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CashTransactionsServiceimpl implements CashTransactionsService {

    @Autowired
    private CashTransactionsDAO dao;

    @Override
    public CashTransactions create(CashTransactions tx) {
        tx.setTransactionDate(LocalDateTime.now());
        return dao.save(tx);
    }

    @Override
    public CashTransactions getById(UUID id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public List<CashTransactions> getAll() {
        return dao.findAll();
    }

    @Override
    public CashTransactions update(UUID id, CashTransactions tx) {
        CashTransactions existing = getById(id);

        existing.setCashierId(tx.getCashierId());
        existing.setAdminId(tx.getAdminId());
        existing.setType(tx.getType());
        existing.setAmount(tx.getAmount());
        existing.setDescription(tx.getDescription());

        return dao.save(existing);
    }

    @Override
    public void delete(UUID id) {
        dao.deleteById(id);
    }
}