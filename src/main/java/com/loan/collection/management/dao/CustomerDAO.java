package com.loan.collection.management.LoanCollectionManagement.dao;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class CustomerDAO {
    private UUID id;
    private String name;
    private String mobile;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String aadhaarNumber;
    private String aadhaarPhoto;
    private String guarantorName;
    private String guarantorMobile;
    private String guarantorAddress;
    private BigDecimal guarantorLatitude;
    private BigDecimal guarantorLongitude;
    private String guarantorAadhaarNumber;
    private String guarantorAadhaarPhoto;
    private UUID createdBy;
    private UUID approvedBy;
    private String status;
    private Timestamp createdAt;

    public CustomerDAO() {}


}
