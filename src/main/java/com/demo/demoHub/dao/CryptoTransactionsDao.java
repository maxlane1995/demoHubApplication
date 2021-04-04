package com.demo.demoHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoHub.crypto.entity.CryptoTransactions;

@Repository
public interface CryptoTransactionsDao extends JpaRepository<CryptoTransactions,Integer>{

}
