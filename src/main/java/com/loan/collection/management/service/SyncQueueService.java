package com.loan.collection.management.service;

import com.loan.collection.management.model.SyncStatus;
import com.loan.collection.management.model.SyncQueue;

import java.util.List;
import java.util.UUID;

public interface SyncQueueService {

    SyncQueue create(SyncQueue syncQueue);

    List<SyncQueue> getAll();

    SyncQueue getById(UUID id);

    List<SyncQueue> getPending();

    SyncQueue updateStatus(UUID id, SyncStatus status);

    void delete(UUID id);
}