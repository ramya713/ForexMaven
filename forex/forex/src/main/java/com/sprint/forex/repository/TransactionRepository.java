package com.sprint.forex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.forex.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
    List<Transaction> findBySenderAccNo(long senderAccNo);
    List<Transaction> findByUserBankDetails_User_UsersId(int usersId);
    
	Optional<Transaction> findById(int transcationId);
}
