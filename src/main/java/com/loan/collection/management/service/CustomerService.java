package com.loan.collection.management.service;

import com.loan.collection.management.LoanCollectionManagement.dao.CustomerDAO;
import com.loan.collection.management.model.ApprovalStatus;
import com.loan.collection.management.model.Customer;
import com.loan.collection.management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // =========================
    // GET ALL
    // =========================
    public List<CustomerDAO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::toDAO).toList();
    }

    // =========================
    // GET BY ID
    // =========================
    public Optional<CustomerDAO> getCustomerById(UUID id) {
        return customerRepository.findById(id).map(this::toDAO);
    }

    // =========================
    // CREATE
    // =========================
    public CustomerDAO createCustomer(CustomerDAO customerDAO) {
        Customer customer = toEntity(customerDAO);
        Customer saved = customerRepository.save(customer);
        return toDAO(saved);
    }

    // =========================
    // 🔥 UPDATE (FIXED + ADDED)
    // =========================
    public Optional<CustomerDAO> updateCustomer(UUID id, CustomerDAO customerDAO) {

        return customerRepository.findById(id).map(existing -> {

            existing.setName(customerDAO.getName());
            existing.setMobile(customerDAO.getMobile());
            existing.setAddress(customerDAO.getAddress());

            existing.setLatitude(customerDAO.getLatitude());
            existing.setLongitude(customerDAO.getLongitude());

            existing.setAadhaarNumber(customerDAO.getAadhaarNumber());
            existing.setAadhaarPhoto(customerDAO.getAadhaarPhoto());

            existing.setGuarantorName(customerDAO.getGuarantorName());
            existing.setGuarantorMobile(customerDAO.getGuarantorMobile());
            existing.setGuarantorAddress(customerDAO.getGuarantorAddress());
            existing.setGuarantorLatitude(customerDAO.getGuarantorLatitude());
            existing.setGuarantorLongitude(customerDAO.getGuarantorLongitude());
            existing.setGuarantorAadhaarNumber(customerDAO.getGuarantorAadhaarNumber());
            existing.setGuarantorAadhaarPhoto(customerDAO.getGuarantorAadhaarPhoto());

            existing.setCreatedBy(customerDAO.getCreatedBy());
            existing.setApprovedBy(customerDAO.getApprovedBy());

            if (customerDAO.getStatus() != null) {
                existing.setStatus(ApprovalStatus.valueOf(customerDAO.getStatus()));
            }

            Customer updated = customerRepository.save(existing);
            return toDAO(updated);
        });
    }

    // =========================
    // DELETE
    // =========================
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    // =========================
    // ENTITY → DAO
    // =========================
    private CustomerDAO toDAO(Customer customer) {
        CustomerDAO dao = new CustomerDAO();

        dao.setId(customer.getId());
        dao.setName(customer.getName());
        dao.setMobile(customer.getMobile());
        dao.setAddress(customer.getAddress());

        dao.setLatitude(customer.getLatitude());
        dao.setLongitude(customer.getLongitude());

        dao.setAadhaarNumber(customer.getAadhaarNumber());
        dao.setAadhaarPhoto(customer.getAadhaarPhoto());

        dao.setGuarantorName(customer.getGuarantorName());
        dao.setGuarantorMobile(customer.getGuarantorMobile());
        dao.setGuarantorAddress(customer.getGuarantorAddress());
        dao.setGuarantorLatitude(customer.getGuarantorLatitude());
        dao.setGuarantorLongitude(customer.getGuarantorLongitude());
        dao.setGuarantorAadhaarNumber(customer.getGuarantorAadhaarNumber());
        dao.setGuarantorAadhaarPhoto(customer.getGuarantorAadhaarPhoto());

        dao.setCreatedBy(customer.getCreatedBy());
        dao.setApprovedBy(customer.getApprovedBy());

        dao.setStatus(customer.getStatus() != null ? customer.getStatus().name() : null);
        dao.setCreatedAt(customer.getCreatedAt());

        return dao;
    }

    // =========================
    // DAO → ENTITY
    // =========================
    private Customer toEntity(CustomerDAO dao) {
        Customer customer = new Customer();

        customer.setId(dao.getId());
        customer.setName(dao.getName());
        customer.setMobile(dao.getMobile());
        customer.setAddress(dao.getAddress());

        customer.setLatitude(dao.getLatitude());
        customer.setLongitude(dao.getLongitude());

        customer.setAadhaarNumber(dao.getAadhaarNumber());
        customer.setAadhaarPhoto(dao.getAadhaarPhoto());

        customer.setGuarantorName(dao.getGuarantorName());
        customer.setGuarantorMobile(dao.getGuarantorMobile());
        customer.setGuarantorAddress(dao.getGuarantorAddress());
        customer.setGuarantorLatitude(dao.getGuarantorLatitude());
        customer.setGuarantorLongitude(dao.getGuarantorLongitude());
        customer.setGuarantorAadhaarNumber(dao.getGuarantorAadhaarNumber());
        customer.setGuarantorAadhaarPhoto(dao.getGuarantorAadhaarPhoto());

        customer.setCreatedBy(dao.getCreatedBy());
        customer.setApprovedBy(dao.getApprovedBy());

        if (dao.getStatus() != null) {
            customer.setStatus(ApprovalStatus.valueOf(dao.getStatus()));
        }

        customer.setCreatedAt(dao.getCreatedAt());

        return customer;
    }
}