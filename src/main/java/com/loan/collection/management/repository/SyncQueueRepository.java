package com.loan.collection.management.repository;

import com.loan.collection.management.model.SyncStatus;
import com.loan.collection.management.model.SyncQueue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SyncQueueRepository extends JpaRepository<SyncQueue, UUID> {

    List<SyncQueue> findBySyncStatus(SyncStatus syncStatus);

    List<SyncQueue> findByUserId(UUID userId);
}