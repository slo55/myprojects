package com.soysaltech.bankeroApp.entity;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String IBAN;
    private String password;
    private String fullName;
    private String country;

    private double balance;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Transfer> transferList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role)
    {
        if (roles == null)
        {
            roles = new HashSet<>();
        }
        this.roles.add(role);
    }

    public void sentMoney(User user, double amount)
    {
        if (this.balance < 0 && this.balance < amount)
        {
            this.balance+= 0;
        }

        this.balance -= amount;
        user.depositMoney(amount);

        this.transferList.add(new Transfer(user, TransferType.SENT,amount));
        user.addTransfer(new Transfer(this, TransferType.RECEIVE, amount));

    }

    public void depositMoney(double amount)
    {
        this.balance += amount;
    }

    public void withdrawMoney(double amount)
    {
        this.balance -= amount;
    }

    public void addTransfer(Transfer transfer)
    {
        this.transferList.add(transfer);
    }


}
