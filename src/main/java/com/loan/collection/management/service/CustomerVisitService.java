package com.loan.collection.management.service;

import com.loan.collection.management.dao.CustomerVisitDAO;
import com.loan.collection.management.model.CustomerVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerVisitService {

    @Autowired
    private CustomerVisitDAO dao;

    public CustomerVisit createVisit(CustomerVisit visit) {
        return dao.save(visit);
    }

    public List<CustomerVisit> getAllVisits() {
        return dao.findAll();
    }

    public CustomerVisit getVisit(UUID id) {
        return dao.findById(id);
    }

    public CustomerVisit updateVisit(UUID id, CustomerVisit updated) {

        CustomerVisit existing = dao.findById(id);

        if (existing == null) {
            throw new RuntimeException("Visit not found");
        }

        existing.setCustomerId(updated.getCustomerId());
        existing.setCashierId(updated.getCashierId());
        existing.setStatus(updated.getStatus());
        existing.setNotes(updated.getNotes());
        existing.setLatitude(updated.getLatitude());
        existing.setLongitude(updated.getLongitude());

        return dao.save(existing);
    }

    public void deleteVisit(UUID id) {
        dao.delete(id);
    }
}