package com.loan.collection.management.dao;

import com.loan.collection.management.model.Notification;
import com.loan.collection.management.repository.NotificationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class NotificationDAOimp implements NotificationDAO {

    private final NotificationRepository repository;

    public NotificationDAOimp(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    @Override
    public List<Notification> findAll() {
        return repository.findAll();
    }

    @Override
    public Notification findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Notification> findByUserId(UUID userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}