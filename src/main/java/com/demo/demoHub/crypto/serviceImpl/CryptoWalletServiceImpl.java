package com.demo.demoHub.crypto.serviceImpl;

import java.io.File;
import java.nio.file.AccessDeniedException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;

import com.demo.demoHub.crypto.entity.CryptoWallet;
import com.demo.demoHub.crypto.entity.Web3jEther;
import com.demo.demoHub.crypto.service.CryptoWalletService;
import com.demo.demoHub.dao.CryptoTransactionsDao;
import com.demo.demoHub.dao.CryptoWalletDao;
import com.demo.demoHub.dao.UserRepo;
import com.demo.demoHub.model.RandomString;
import com.demo.demoHub.model.Result;
import com.demo.demoHub.model.User;



@Service
public class CryptoWalletServiceImpl implements CryptoWalletService {

	private static final Logger logger = LoggerFactory.getLogger(CryptoWalletServiceImpl.class);
	
	RandomString randomString = new RandomString();
	
	@Autowired
	private Web3jEther ether;
	
	@Autowired
	private CryptoTransactionsDao cryptoTransactionRepo;

	@Autowired
	private CryptoWalletDao cryptoWalletRepo;
	

	@Autowired
	private UserRepo userRepo;

	
	@Override
	public Result createEtherWallet() {
		Result result = new Result();
		String logedUser = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepo.findByusername(logedUser);
		CryptoWallet userWallet = new CryptoWallet();
		File file = new File("C:\\Users\\acer\\Desktop\\practiceDemo\\EthereumWallets");
		String finalString = randomString.nextString();
		Web3j web3j = ether.getWeb3j();
		try {
			
			if (user == null) {
				logger.info("NO USER FOUND FOR THIS LOGIN");
				result.setSuccess(false);
				result.setSuccessMessage("USER NOT FOUND");
			}
			String etherAddress = WalletUtils.generateNewWalletFile("password", file,true);
			Credentials credentials = WalletUtils.loadCredentials("password", file);
			List<CryptoWallet> crypto = cryptoWalletRepo.findAllByUserId(user.getId());
			if(! (crypto == null)) {
				for(CryptoWallet cryptos:crypto) {
					if (cryptos.getMain() == true ) {
						
					}else {
						userWallet.setMain(Boolean.FALSE);
					}
				}
			}
			return result;
		} catch (Exception e) {
			logger.info(e.getMessage().toString());
		}

		return new Result();
	}

}
