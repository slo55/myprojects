package com.soysaltech.bankeroApp.repository;

import com.soysaltech.bankeroApp.entity.Transfer;
import com.soysaltech.bankeroApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long>
{
}
