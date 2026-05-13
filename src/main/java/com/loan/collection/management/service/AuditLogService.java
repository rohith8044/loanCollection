package com.loan.collection.management.service;

import com.loan.collection.management.model.AuditLog;

import java.util.List;
import java.util.UUID;

public interface AuditLogService {

    AuditLog create(AuditLog log);

    List<AuditLog> getAll();

    AuditLog getById(UUID id);

    AuditLog update(UUID id, AuditLog log);

    void delete(UUID id);
}