package com.tekarch.userManagementMs.repositories;

import com.tekarch.userManagementMs.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserUserId(Long userId);
}