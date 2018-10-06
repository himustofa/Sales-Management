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
@Table(name = "suppliers")
public class Supplier {

	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "supplier_company_name")
	private String supplierCompanyName;

	@Column(name = "supplier_contact_person")
	private String supplierContactPerson;

	@Column(name = "supplier_phone_number")
	private String supplierPhoneNumber;

	@Column(name = "supplier_address")
	private String supplierAddress;

	@Column(name = "supplier_bank_name")
	private String supplierBankName;

	@Column(name = "supplier_bank_account")
	private String supplierBankAccount;

	@Column(name = "supplier_email")
	private String supplierEmail;

	@Column(name = "supplier_website")
	private String supplierWebsite;

	@Column(name = "supplier_description")
	private String supplierDescription;

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierCompanyName() {
		return supplierCompanyName;
	}

	public void setSupplierCompanyName(String supplierCompanyName) {
		this.supplierCompanyName = supplierCompanyName;
	}

	public String getSupplierContactPerson() {
		return supplierContactPerson;
	}

	public void setSupplierContactPerson(String supplierContactPerson) {
		this.supplierContactPerson = supplierContactPerson;
	}

	public String getSupplierPhoneNumber() {
		return supplierPhoneNumber;
	}

	public void setSupplierPhoneNumber(String supplierPhoneNumber) {
		this.supplierPhoneNumber = supplierPhoneNumber;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierBankName() {
		return supplierBankName;
	}

	public void setSupplierBankName(String supplierBankName) {
		this.supplierBankName = supplierBankName;
	}

	public String getSupplierBankAccount() {
		return supplierBankAccount;
	}

	public void setSupplierBankAccount(String supplierBankAccount) {
		this.supplierBankAccount = supplierBankAccount;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	public String getSupplierWebsite() {
		return supplierWebsite;
	}

	public void setSupplierWebsite(String supplierWebsite) {
		this.supplierWebsite = supplierWebsite;
	}

	public String getSupplierDescription() {
		return supplierDescription;
	}

	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription;
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

}
