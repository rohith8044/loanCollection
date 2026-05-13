package com.loan.collection.management.service.impl;

import com.loan.collection.management.dao.AuditLogDao;
import com.loan.collection.management.model.AuditLog;
import com.loan.collection.management.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogDao dao;

    @Override
    public AuditLog create(AuditLog log) {
        return dao.save(log);
    }

    @Override
    public List<AuditLog> getAll() {
        return dao.findAll();
    }

    @Override
    public AuditLog getById(UUID id) {
        return dao.findById(id);
    }

    @Override
    public AuditLog update(UUID id, AuditLog log) {

        AuditLog existing = dao.findById(id);

        if (existing == null) {
            throw new RuntimeException("Audit Log not found");
        }

        existing.setAction(log.getAction());
        existing.setEntityType(log.getEntityType());
        existing.setEntityId(log.getEntityId());
        existing.setUserId(log.getUserId());
        existing.setOldData(log.getOldData());
        existing.setNewData(log.getNewData());

        return dao.save(existing);
    }

    @Override
    public void delete(UUID id) {
        dao.deleteById(id);
    }
}