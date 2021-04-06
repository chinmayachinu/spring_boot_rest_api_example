package com.example.cca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	private String customerName;
	private String companyName;
	@Id
	@Column(name = "userId")
	private long userId;
	private int customerDatabaseId;
	private long districtId;
	private String createDate;
	private String transactionDate;

	public Customer() {
	}

	public Customer(String customerName, String companyName, long userId, int customerDatabaseId, long districtId,
			String createDate, String transactionDate) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.userId = userId;
		this.customerDatabaseId = customerDatabaseId;
		this.districtId = districtId;
		this.createDate = createDate;
		this.transactionDate = transactionDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getCustomerDatabaseId() {
		return customerDatabaseId;
	}

	public void setCustomerDatabaseId(int customerDatabaseId) {
		this.customerDatabaseId = customerDatabaseId;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

}
