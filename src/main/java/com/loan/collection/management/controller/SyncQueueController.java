package com.loan.collection.management.controller;

import com.loan.collection.management.model.SyncStatus;
import com.loan.collection.management.model.SyncQueue;
import com.loan.collection.management.service.SyncQueueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sync-queue")
public class SyncQueueController {

    @Autowired
    private SyncQueueService service;

    // CREATE
    @PostMapping
    public SyncQueue create(@RequestBody SyncQueue syncQueue) {
        return service.create(syncQueue);
    }

    // GET ALL
    @GetMapping
    public List<SyncQueue> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public SyncQueue getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    // GET PENDING
    @GetMapping("/pending")
    public List<SyncQueue> getPending() {
        return service.getPending();
    }

    // UPDATE STATUS
    @PutMapping("/{id}/status")
    public SyncQueue updateStatus(
            @PathVariable UUID id,
            @RequestParam SyncStatus status) {
        return service.updateStatus(id, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}