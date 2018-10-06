package com.mk.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "customers")
public class Customer {

	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_phone_number")
	private String customerPhoneNumber;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "customer_contact_person")
	private String customerContactPerson;

	@Column(name = "customer_discount")
	private double customerDiscount;

	@Column(name = "customer_address")
	private String customerAddress;

	@Column(name = "customer_description")
	private String customerDescription;

	@Column(name = "created_by_id")
	private UUID createdById;

	@Column(name = "updated_by_id")
	private UUID updatedById;

	@Column(name = "created_at")
	private Timestamp createdAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerContactPerson() {
		return customerContactPerson;
	}

	public void setCustomerContactPerson(String customerContactPerson) {
		this.customerContactPerson = customerContactPerson;
	}

	public double getCustomerDiscount() {
		return customerDiscount;
	}

	public void setCustomerDiscount(double customerDiscount) {
		this.customerDiscount = customerDiscount;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerDescription() {
		return customerDescription;
	}

	public void setCustomerDescription(String customerDescription) {
		this.customerDescription = customerDescription;
	}

	public UUID getCreatedById() {
		return createdById;
	}

	public void setCreatedById(UUID createdById) {
		this.createdById = createdById;
	}

	public UUID getUpdatedById() {
		return updatedById;
	}

	public void setUpdatedById(UUID updatedById) {
		this.updatedById = updatedById;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerPhoneNumber=" + customerPhoneNumber
				+ ", customerEmail=" + customerEmail + ", customerContactPerson=" + customerContactPerson
				+ ", customerDiscount=" + customerDiscount + ", customerAddress=" + customerAddress
				+ ", customerDescription=" + customerDescription + ", createdById=" + createdById + ", updatedById="
				+ updatedById + ", createdAt=" + createdAt + "]";
	}

}