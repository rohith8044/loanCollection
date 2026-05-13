package com.loan.collection.management.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cash_box")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashBox {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "admin_id")
    private UUID adminId;

    private LocalDate date;

    private BigDecimal openingBalance;

    private BigDecimal closingBalance;
}