package com.loan.collection.management.dao.impl;

import com.loan.collection.management.dao.AuditLogDao;
import com.loan.collection.management.model.AuditLog;
import com.loan.collection.management.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AuditLogDaoImpl implements AuditLogDao {

    @Autowired
    private AuditLogRepository repo;

    @Override
    public AuditLog save(AuditLog log) {
        return repo.save(log);
    }

    @Override
    public List<AuditLog> findAll() {
        return repo.findAll();
    }

    @Override
    public AuditLog findById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}