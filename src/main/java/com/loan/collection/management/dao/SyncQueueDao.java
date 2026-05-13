package com.loan.collection.management.dao;

import com.loan.collection.management.model.SyncStatus;
import com.loan.collection.management.model.SyncQueue;

import java.util.List;
import java.util.UUID;

public interface SyncQueueDao {

    SyncQueue save(SyncQueue syncQueue);

    List<SyncQueue> findAll();

    SyncQueue findById(UUID id);

    List<SyncQueue> findByStatus(SyncStatus status);

    void delete(UUID id);
}