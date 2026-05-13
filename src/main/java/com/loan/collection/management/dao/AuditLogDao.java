package com.loan.collection.management.dao;

import com.loan.collection.management.model.AuditLog;

import java.util.List;
import java.util.UUID;

public interface AuditLogDao {

    AuditLog save(AuditLog log);

    List<AuditLog> findAll();

    AuditLog findById(UUID id);

    void deleteById(UUID id);
}