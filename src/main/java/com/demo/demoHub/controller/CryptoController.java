package com.demo.demoHub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demoHub.crypto.service.CryptoWalletService;
import com.demo.demoHub.model.Result;

@RestController
public class CryptoController {

	public static final Logger logger = LoggerFactory.getLogger(CryptoController.class);
	
	@Autowired
	private CryptoWalletService cryptoWalletService;
	
	@PreAuthorize("hasAuthority ('USER')")
	@RequestMapping(value = "/createether", method = RequestMethod.POST)
	public Result createEther() {
		try {
			return cryptoWalletService.createEtherWallet();
			
		}catch(Exception e) {
			logger.info(e.getMessage().toString());
		}
		return new Result();
	}
	
}
