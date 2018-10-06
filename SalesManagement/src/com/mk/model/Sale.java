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
@Table(name = "sales")
public class Sale {

	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_id")
	private UUID productId;

	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "purchase_product_quantity")
	private int purchaseProductQuantity;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_id")
	private UUID customerId;

	@Column(name = "sales_date")
	private String salesDate;

	@Column(name = "sales_discount")
	private double salesDiscount;

	@Column(name = "sales_vat")
	private double salesVat;

	@Column(name = "sales_amount")
	private double salesAmount;

	@Column(name = "sales_payment")
	private double salesPayment;

	@Column(name = "sales_balance")
	private double salesBalance;

	@Column(name = "sales_description")
	private String salesDescription;

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

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}

	public double getSalesDiscount() {
		return salesDiscount;
	}

	public void setSalesDiscount(double salesDiscount) {
		this.salesDiscount = salesDiscount;
	}

	public double getSalesVat() {
		return salesVat;
	}

	public void setSalesVat(double salesVat) {
		this.salesVat = salesVat;
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}

	public double getSalesPayment() {
		return salesPayment;
	}

	public void setSalesPayment(double salesPayment) {
		this.salesPayment = salesPayment;
	}

	public double getSalesBalance() {
		return salesBalance;
	}

	public void setSalesBalance(double salesBalance) {
		this.salesBalance = salesBalance;
	}

	public String getSalesDescription() {
		return salesDescription;
	}

	public void setSalesDescription(String salesDescription) {
		this.salesDescription = salesDescription;
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

	public int getPurchaseProductQuantity() {
		return purchaseProductQuantity;
	}

	public void setPurchaseProductQuantity(int purchaseProductQuantity) {
		this.purchaseProductQuantity = purchaseProductQuantity;
	}

}