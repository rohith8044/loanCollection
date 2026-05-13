package com.loan.collection.management.service;

import com.loan.collection.management.model.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService {

    Notification create(Notification notification);

    List<Notification> getAll();

    Notification getById(UUID id);

    List<Notification> getByUserId(UUID userId);

    Notification update(UUID id, Notification notification);

    void delete(UUID id);
}