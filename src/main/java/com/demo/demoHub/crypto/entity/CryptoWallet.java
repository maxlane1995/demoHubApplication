package com.demo.demoHub.crypto.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jboss.logging.Logger;
import org.web3j.protocol.Web3j;

import com.demo.demoHub.model.User;

@Entity
@Table(name = "cryptowallets")
public class CryptoWallet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "code")
	private String code;

	@Column(name = "currency")
	private String currency;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user")
	private User user;

	@Column(name = "main")
	private boolean main;

	@Column(name = "identifier")
	private String identifier;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean getMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public String toString() {
		return "CryptoWallet [id=" + id + ", address=" + address + ", code=" + code + ", currency=" + currency
				+ ", user=" + user + ", main=" + main + ", identifier=" + identifier + "]";
	}

	public static void main(String[] args) {
		System.out.println( args.length );
		int k = 0;
		try {
			File dir = new File("C:\\Users\\acer\\Desktop\\practiceDemo");
			File file = new File("C:\\Users\\acer\\Desktop\\practiceDemo\\practice.txt"); // take a file from directory
																							// as a file
			// object
			if (!dir.exists()) {
				dir.mkdir(); // this is for directory
			}
			if (!file.exists()) { // if file is not exist then create the file and and also same for the directory
									// create the directory.
				file.createNewFile(); // and this is for file
			}
			FileReader fm = new FileReader(file);
			FileWriter fr = new FileWriter(file);
			
			if (fm.read() == -1) {
				fr.write("nase.....eeeeee no un nani jamada aaaaaa no hullaralo ");
			}
			while ((k = fm.read()) != -1) {
				System.out.print(String.valueOf(k));
			}
		} catch (Exception e) {
			Logger.getLogger(CryptoWallet.class).error(e.toString());
		}

		Web3j wb = new Web3jEther().getWeb3j();
		System.out.println(wb);
		String abc = "123";
		String xyz = "123";
		String duplicate = "ksjf;lsakfj;lsfkj;lsfj";
		xyz.concat("tereere");
		String a = new String(xyz);
		String aa = new String("123");
		System.out.println(a.equals(aa));
		System.out.println(a == aa);
		System.out.println("String var " + abc.equals(a));
		System.out.println("String new " + abc == a);
		String check = "";
		for (int i = 0; i < duplicate.length(); i++) {
			if (!(check.contains(String.valueOf(duplicate.charAt(i))))) {
				check += duplicate.charAt(i);
			}
		}

		System.out.println("check :   " + check);
		Set<String> set = new HashSet<String>();
		char[] arr = duplicate.toCharArray();

		for (Character chars : arr) {
			set.add(chars.toString(chars));
		}
		System.out.println("Check with set:  " + set);
		System.out.println(new String("123").intern());

	}

}
