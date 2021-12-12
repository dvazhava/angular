package com.example.customerproducer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Producer")
public class customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column (name = "name", nullable = false)
	private String name;
	
	@Column (name = "age", nullable = false)
	private int age;
	
	@Column (name = "address", nullable = false)
	private String address;
	
	@Column (name = "account", nullable = false)
	private String account;
	
	public customer() {
		
	}

	public customer(int id, String name, int age, String address, String account) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", account="
				+ account + "]";
	}
	
	
	
	
	

}
