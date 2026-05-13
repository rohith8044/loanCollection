package com.loan.collection.management.service;

import com.loan.collection.management.dao.CashBoxDAO;
import com.loan.collection.management.model.CashBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CashBoxService {

    @Autowired
    private CashBoxDAO cashBoxDAO;

    // CREATE
    public CashBox createCashBox(CashBox cashBox) {
        return cashBoxDAO.save(cashBox);
    }

    // GET ALL
    public List<CashBox> getAll() {
        return cashBoxDAO.findAll();
    }

    // GET BY ID
    public CashBox getById(UUID id) {
        return cashBoxDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("CashBox not found"));
    }

    // UPDATE
    public CashBox update(UUID id, CashBox newData) {
        CashBox existing = getById(id);

        existing.setAdminId(newData.getAdminId());
        existing.setDate(newData.getDate());
        existing.setOpeningBalance(newData.getOpeningBalance());
        existing.setClosingBalance(newData.getClosingBalance());

        return cashBoxDAO.save(existing);
    }

    // DELETE
    public String delete(UUID id) {
        cashBoxDAO.deleteById(id);
        return "Deleted successfully";
    }
}