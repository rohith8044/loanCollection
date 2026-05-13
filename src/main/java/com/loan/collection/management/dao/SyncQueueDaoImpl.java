package com.loan.collection.management.dao;

import com.loan.collection.management.dao.SyncQueueDao;
import com.loan.collection.management.model.SyncStatus;
import com.loan.collection.management.model.SyncQueue;
import com.loan.collection.management.repository.SyncQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SyncQueueDaoImpl implements SyncQueueDao {

    @Autowired
    private SyncQueueRepository repository;

    @Override
    public SyncQueue save(SyncQueue syncQueue) {
        return repository.save(syncQueue);
    }

    @Override
    public List<SyncQueue> findAll() {
        return repository.findAll();
    }

    @Override
    public SyncQueue findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SyncQueue> findByStatus(SyncStatus status) {
        return repository.findBySyncStatus(status);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}