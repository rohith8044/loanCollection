package com.loan.collection.management.service;

import com.loan.collection.management.dao.NotificationDAO;
import com.loan.collection.management.model.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDAO dao;

    public NotificationServiceImpl(NotificationDAO dao) {
        this.dao = dao;
    }

    @Override
    public Notification create(Notification notification) {
        return dao.save(notification);
    }

    @Override
    public List<Notification> getAll() {
        return dao.findAll();
    }

    @Override
    public Notification getById(UUID id) {
        return dao.findById(id);
    }

    @Override
    public List<Notification> getByUserId(UUID userId) {
        return dao.findByUserId(userId);
    }

    @Override
    public Notification update(UUID id, Notification notification) {

        Notification existing = dao.findById(id);

        if (existing == null) return null;

        existing.setMessage(notification.getMessage());
        existing.setType(notification.getType());
        existing.setRead(notification.isRead());

        return dao.save(existing);
    }

    @Override
    public void delete(UUID id) {
        dao.deleteById(id);
    }
}