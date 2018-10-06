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
@Table(name = "purchases")
public class Purchase {

	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_id")
	private UUID productId;

	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "supplier_id")
	private UUID supplierId;
	
	@Column(name = "purchase_product_quantity")
	private int purchaseProductQuantity;
	
	@Column(name = "purchase_product_price")
	private double purchaseProductPrice;

	@Column(name = "purchase_date")
	private String purchaseDate;

	@Column(name = "purchase_amount")
	private double purchaseAmount;

	@Column(name = "purchase_payment")
	private double purchasePayment;

	@Column(name = "purchase_balance")
	private double purchaseBalance;

	@Column(name = "purchase_description")
	private String purchaseDescription;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public int getPurchaseProductQuantity() {
		return purchaseProductQuantity;
	}

	public void setPurchaseProductQuantity(int purchaseProductQuantity) {
		this.purchaseProductQuantity = purchaseProductQuantity;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public UUID getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(UUID supplierId) {
		this.supplierId = supplierId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public double getPurchasePayment() {
		return purchasePayment;
	}

	public void setPurchasePayment(double purchasePayment) {
		this.purchasePayment = purchasePayment;
	}

	public double getPurchaseBalance() {
		return purchaseBalance;
	}

	public void setPurchaseBalance(double purchaseBalance) {
		this.purchaseBalance = purchaseBalance;
	}

	public String getPurchaseDescription() {
		return purchaseDescription;
	}

	public void setPurchaseDescription(String purchaseDescription) {
		this.purchaseDescription = purchaseDescription;
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

	public double getPurchaseProductPrice() {
		return purchaseProductPrice;
	}

	public void setPurchaseProductPrice(double purchaseProductPrice) {
		this.purchaseProductPrice = purchaseProductPrice;
	}

}