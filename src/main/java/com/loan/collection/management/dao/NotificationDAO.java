package com.loan.collection.management.dao;

import com.loan.collection.management.model.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationDAO {

    Notification save(Notification notification);

    List<Notification> findAll();

    Notification findById(UUID id);

    List<Notification> findByUserId(UUID userId);

    void deleteById(UUID id);
}