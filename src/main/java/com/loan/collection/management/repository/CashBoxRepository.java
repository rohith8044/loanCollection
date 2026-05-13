package com.loan.collection.management.repository;

import com.loan.collection.management.model.CashBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CashBoxRepository extends JpaRepository<CashBox, UUID> {
}