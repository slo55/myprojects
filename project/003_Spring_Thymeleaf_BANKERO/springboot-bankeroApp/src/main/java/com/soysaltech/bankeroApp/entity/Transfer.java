package com.soysaltech.bankeroApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transfer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transferUser_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    private double transferAmount;

    public Transfer(User user, TransferType sent, double transferAmount)
    {
        this.transferType = sent;
        this.user = user;
        this.transferAmount = transferAmount;
    }
}
