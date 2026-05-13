package com.loan.collection.management.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cash_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CashTransactions {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID cashierId;

    private UUID adminId;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal amount;

    private String description;

    private LocalDateTime transactionDate;
}