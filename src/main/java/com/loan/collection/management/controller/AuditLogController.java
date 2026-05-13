package com.loan.collection.management.controller;

import com.loan.collection.management.model.AuditLog;
import com.loan.collection.management.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService service;

    // CREATE
    @PostMapping
    public AuditLog create(@RequestBody AuditLog log) {
        return service.create(log);
    }

    // GET ALL
    @GetMapping
    public List<AuditLog> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public AuditLog getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public AuditLog update(@PathVariable UUID id, @RequestBody AuditLog log) {
        return service.update(id, log);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Audit Log deleted successfully";
    }
}