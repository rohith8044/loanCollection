package com.loan.collection.management.controller;

import com.loan.collection.management.model.ApprovalRequest;
import com.loan.collection.management.service.ApprovalRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/approval-requests")
public class ApprovalRequestController {

    @Autowired
    private ApprovalRequestService service;

    // CREATE
    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.createRequest(request);
    }

    // GET ALL
    @GetMapping
    public List<ApprovalRequest> getAll() {
        return service.getAllRequests();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ApprovalRequest getById(@PathVariable UUID id) {
        return service.getRequestById(id);
    }

    // APPROVE
    @PutMapping("/{id}/approve")
    public ApprovalRequest approve(
            @PathVariable UUID id,
            @RequestParam UUID adminId) {
        return service.approveRequest(id, adminId);
    }

    // REJECT
    @PutMapping("/{id}/reject")
    public ApprovalRequest reject(
            @PathVariable UUID id,
            @RequestParam UUID adminId) {
        return service.rejectRequest(id, adminId);
    }

    

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.deleteRequest(id);
        return "Deleted Successfully";
    }
}