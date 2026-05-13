package com.loan.collection.management.controller;

import com.loan.collection.management.model.Notification;
import com.loan.collection.management.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification create(@RequestBody Notification notification) {
        return service.create(notification);
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Notification getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getByUser(@PathVariable UUID userId) {
        return service.getByUserId(userId);
    }

    @PutMapping("/{id}")
    public Notification update(@PathVariable UUID id,
                               @RequestBody Notification notification) {
        return service.update(id, notification);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Deleted successfully";
    }
}