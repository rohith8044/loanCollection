package com.loan.collection.management.service;

import com.loan.collection.management.dao.ApprovalRequestDAO;
import com.loan.collection.management.model.ApprovalRequest;
import com.loan.collection.management.model.ApprovalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ApprovalRequestService {

    @Autowired
    private ApprovalRequestDAO dao;

    public ApprovalRequest createRequest(ApprovalRequest request) {
        request.setStatus(ApprovalStatus.PENDING);
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());
        return dao.save(request);
    }

    public List<ApprovalRequest> getAllRequests() {
        return dao.findAll();
    }

    public ApprovalRequest getRequestById(UUID id) {
        return dao.findById(id);
    }

    public ApprovalRequest approveRequest(UUID id, UUID adminId) {
        ApprovalRequest req = dao.findById(id);

        if (req == null) {
            throw new RuntimeException("Request not found");
        }

        req.setStatus(ApprovalStatus.APPROVED);
        req.setApprovedBy(adminId);
        req.setUpdatedAt(LocalDateTime.now());

        return dao.save(req);
    }

    public ApprovalRequest rejectRequest(UUID id, UUID adminId) {
        ApprovalRequest req = dao.findById(id);

        if (req == null) {
            throw new RuntimeException("Request not found");
        }

        req.setStatus(ApprovalStatus.REJECTED);
        req.setApprovedBy(adminId);
        req.setUpdatedAt(LocalDateTime.now());

        return dao.save(req);
    }

    public void deleteRequest(UUID id) {
        dao.delete(id);
    }
}