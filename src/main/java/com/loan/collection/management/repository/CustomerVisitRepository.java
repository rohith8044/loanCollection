package com.loan.collection.management.repository;

import com.loan.collection.management.model.CustomerVisit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerVisitRepository extends JpaRepository<CustomerVisit, UUID> {
}