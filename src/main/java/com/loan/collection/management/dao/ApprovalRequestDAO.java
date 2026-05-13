package com.loan.collection.management.dao;

import com.loan.collection.management.model.ApprovalRequest;
import com.loan.collection.management.repository.ApprovalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ApprovalRequestDAO {

    @Autowired
    private ApprovalRequestRepository repository;

    public ApprovalRequest save(ApprovalRequest request) {
        return repository.save(request);
    }

    public List<ApprovalRequest> findAll() {
        return repository.findAll();
    }

    public ApprovalRequest findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}