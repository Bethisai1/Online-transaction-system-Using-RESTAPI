package com.sai.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class bankapplication {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long account;
	private String name;
	private String password;
	private double amount;
	private String address;
    private int mobile;
	public bankapplication() {
		super();
	}
	public bankapplication(int id, long account, String name, String password, double amount, String address,
			int mobile) {
		super();
		this.id = id;
		this.account = account;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "bankapplication [id=" + id + ", account=" + account + ", name=" + name + ", password=" + password
				+ ", amount=" + amount + ", address=" + address + ", mobile=" + mobile + "]";
	}
	
    

    
}
