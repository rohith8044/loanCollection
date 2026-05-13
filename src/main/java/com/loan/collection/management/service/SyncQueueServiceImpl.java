package com.loan.collection.management.service;

import com.loan.collection.management.dao.SyncQueueDao;
import com.loan.collection.management.model.SyncStatus;
import com.loan.collection.management.model.SyncQueue;
import com.loan.collection.management.service.SyncQueueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SyncQueueServiceImpl implements SyncQueueService {

    @Autowired
    private SyncQueueDao dao;

    @Override
    public SyncQueue create(SyncQueue syncQueue) {
        syncQueue.setSyncStatus(SyncStatus.PENDING);
        return dao.save(syncQueue);
    }

    @Override
    public List<SyncQueue> getAll() {
        return dao.findAll();
    }

    @Override
    public SyncQueue getById(UUID id) {
        return dao.findById(id);
    }

    @Override
    public List<SyncQueue> getPending() {
        return dao.findByStatus(SyncStatus.PENDING);
    }

    @Override
    public SyncQueue updateStatus(UUID id, SyncStatus status) {
        SyncQueue queue = dao.findById(id);
        if (queue == null) {
            throw new RuntimeException("SyncQueue not found");
        }
        queue.setSyncStatus(status);
        return dao.save(queue);
    }

    @Override
    public void delete(UUID id) {
        dao.delete(id);
    }
}