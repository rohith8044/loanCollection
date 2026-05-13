package com.loan.collection.management.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
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

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status = ApprovalStatus.PENDING;

    private Timestamp createdAt;

    public Customer() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public BigDecimal getLatitude() { return latitude; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    public BigDecimal getLongitude() { return longitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }
    public String getAadhaarNumber() { return aadhaarNumber; }
    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }
    public String getAadhaarPhoto() { return aadhaarPhoto; }
    public void setAadhaarPhoto(String aadhaarPhoto) { this.aadhaarPhoto = aadhaarPhoto; }
    public String getGuarantorName() { return guarantorName; }
    public void setGuarantorName(String guarantorName) { this.guarantorName = guarantorName; }
    public String getGuarantorMobile() { return guarantorMobile; }
    public void setGuarantorMobile(String guarantorMobile) { this.guarantorMobile = guarantorMobile; }
    public String getGuarantorAddress() { return guarantorAddress; }
    public void setGuarantorAddress(String guarantorAddress) { this.guarantorAddress = guarantorAddress; }
    public BigDecimal getGuarantorLatitude() { return guarantorLatitude; }
    public void setGuarantorLatitude(BigDecimal guarantorLatitude) { this.guarantorLatitude = guarantorLatitude; }
    public BigDecimal getGuarantorLongitude() { return guarantorLongitude; }
    public void setGuarantorLongitude(BigDecimal guarantorLongitude) { this.guarantorLongitude = guarantorLongitude; }
    public String getGuarantorAadhaarNumber() { return guarantorAadhaarNumber; }
    public void setGuarantorAadhaarNumber(String guarantorAadhaarNumber) { this.guarantorAadhaarNumber = guarantorAadhaarNumber; }
    public String getGuarantorAadhaarPhoto() { return guarantorAadhaarPhoto; }
    public void setGuarantorAadhaarPhoto(String guarantorAadhaarPhoto) { this.guarantorAadhaarPhoto = guarantorAadhaarPhoto; }
    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }
    public UUID getApprovedBy() { return approvedBy; }
    public void setApprovedBy(UUID approvedBy) { this.approvedBy = approvedBy; }
    public ApprovalStatus getStatus() { return status; }
    public void setStatus(ApprovalStatus status) { this.status = status; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
