package com.demo.demoHub.crypto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.demo.demoHub.model.User;

@Entity
@Table(name = "cryptotransactions")
public class CryptoTransactions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "balance")
	private float balance;

	@Column(name = "transaction")
	private String transaction;

	@Column(name = "transactioMsg")
	private String transactionMsg;

	@Column(name = "lastUpdated")
	private Date lastUpdated;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne(targetEntity = CryptoWallet.class)
	@JoinColumn(name = "cryptowallet")
	private CryptoWallet crypto;

	@Column(name = "transactionType")
	private String transactionType;

	@Column(name = "incomingAddress")
	private String incomingAddress;

	@Column(name = "outgoingAddress")
	private String outgoingAddress;

	@Column(name = "coinin")
	private float coinin;

	@Column(name = "coinout")
	private float coinout;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getTransactionMsg() {
		return transactionMsg;
	}

	public void setTransactionMsg(String transactionMsg) {
		this.transactionMsg = transactionMsg;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CryptoWallet getCrypto() {
		return crypto;
	}

	public void setCrypto(CryptoWallet crypto) {
		this.crypto = crypto;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		transactionType = transactionType;
	}

	public String getIncomingAddress() {
		return incomingAddress;
	}

	public void setIncomingAddress(String incomingAddress) {
		this.incomingAddress = incomingAddress;
	}

	public String getOutgoingAddress() {
		return outgoingAddress;
	}

	public void setOutgoingAddress(String outgoingAddress) {
		this.outgoingAddress = outgoingAddress;
	}

	public float getCoinin() {
		return coinin;
	}

	public void setCoinin(float coinin) {
		this.coinin = coinin;
	}

	public float getCoinout() {
		return coinout;
	}

	public void setCoinout(float coinout) {
		this.coinout = coinout;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CryptoTransactions [id=" + id + ", address=" + address + ", balance=" + balance + ", transaction="
				+ transaction + ", transactionMsg=" + transactionMsg + ", lastUpdated=" + lastUpdated + ", user=" + user
				+ ", crypto=" + crypto + ", transactionType=" + transactionType + ", incomingAddress=" + incomingAddress
				+ ", outgoingAddress=" + outgoingAddress + ", coinin=" + coinin + ", coinout=" + coinout + "]";
	}

}
