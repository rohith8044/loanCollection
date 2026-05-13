package com.loan.collection.management.repository;

import com.loan.collection.management.model.CashTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CashTransactionsRepository extends JpaRepository<CashTransactions, UUID> {
}