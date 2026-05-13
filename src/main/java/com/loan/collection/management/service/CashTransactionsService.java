package com.loan.collection.management.service;

import com.loan.collection.management.model.CashTransactions;

import java.util.List;
import java.util.UUID;

public interface CashTransactionsService {

    CashTransactions create(CashTransactions tx);

    CashTransactions getById(UUID id);

    List<CashTransactions> getAll();

    CashTransactions update(UUID id, CashTransactions
            tx);

    void delete(UUID id);
}