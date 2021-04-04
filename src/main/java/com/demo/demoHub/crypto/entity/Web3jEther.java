package com.demo.demoHub.crypto.entity;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.stereotype.Component;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import com.demo.demoHub.model.RandomString;



public final class Web3jEther {
	// here these two are the main and test net for infura and web3j is the json RPC
	// client to connect infura server
	private final static String mainNet = "https://mainnet.infura.io/v3/70ac415e6dc244f29111b23061cf3543";
	private final static String testNet = "https://rinkeby.infura.io/v3/70ac415e6dc244f29111b23061cf3543";

	public static Web3j getWeb3j() {

		//HttpService httpService = new HttpService(testNet);
		Web3j web3j = Web3j.build(new HttpService(testNet));

		Web3ClientVersion clientVersion = null;

		try {
			clientVersion = web3j.web3ClientVersion().send();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return web3j;
	}
	public static void main(String[] args) {
		Web3j web = getWeb3j();
		ECKeyPair ecKeyPair = ECKeyPair.create(new BigInteger("23542345234334524"));
		
		RandomString randomString = new RandomString();
		File file = new File("C:\\Users\\acer\\Desktop\\practiceDemo\\EthereumWallets");
		
		String finalString = randomString.nextString();
		try {
			String address = WalletUtils.generateWalletFile("password", ecKeyPair, file, true);
			String etherAddress = WalletUtils.generateNewWalletFile("password", file,true);
			Credentials credentials = WalletUtils.loadCredentials("password", file);
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			
			e.printStackTrace();
		} catch (CipherException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
}
