package com.demo.demoHub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoHub.crypto.entity.CryptoWallet;

@Repository
public interface CryptoWalletDao extends JpaRepository<CryptoWallet, Integer> {
	List<CryptoWallet> findAllByUserId(int id);
}
