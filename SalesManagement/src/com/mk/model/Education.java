package com.mk.model;

import java.io.Serializable;
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
@Table(name = "hr_employee_educations")
public class Education implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "emp_id")
	private UUID empId;

	@Column(name = "emp_code")
	public String empCode;

	@Column(name = "emp_name")
	public String empName;

	@Column(name = "company_code")
	public String companyCode;

	@Column(name = "company_name")
	public String companyName;

	@Column(name = "degree")
	public String degree;

	@Column(name = "institution")
	public String institution;

	@Column(name = "passing_year")
	public String passingYear;

	@Column(name = "result")
	public String result;

	@Column(name = "education_type")
	public String educationType;

	@Column(name = "edu_mgt")
	public String eduMgt;

	@Column(name = "institute")
	public String institute;

	@Column(name = "remark")
	public String remark;

	@Column(name = "client_code")
	public String clientCode;

	@Column(name = "client_name")
	public String clientName;

	@Column(name = "created_by_code")
	private String createdByCode;

	@Column(name = "created_by_name")
	private String createdByName;

	@Column(name = "created_by_username")
	private String createdByUsername;

	@Column(name = "created_by_email")
	private String createdByEmail;

	@Column(name = "created_by_company_code")
	private String createdByCompanyCode;

	@Column(name = "created_by_company_name")
	private String createdByCompanyName;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_by_code")
	private String updatedByCode;

	@Column(name = "updated_by_name")
	private String updatedByName;

	@Column(name = "updated_by_username")
	private String updatedByUsername;

	@Column(name = "updated_by_email")
	private String updatedByEmail;

	@Column(name = "updated_by_company_code")
	private String updatedByCompanyCode;

	@Column(name = "updated_by_company_name")
	private String updatedByCompanyName;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getEmpId() {
		return empId;
	}

	public void setEmpId(UUID empId) {
		this.empId = empId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getEducationType() {
		return educationType;
	}

	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}

	public String getEduMgt() {
		return eduMgt;
	}

	public void setEduMgt(String eduMgt) {
		this.eduMgt = eduMgt;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCreatedByCode() {
		return createdByCode;
	}

	public void setCreatedByCode(String createdByCode) {
		this.createdByCode = createdByCode;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getCreatedByUsername() {
		return createdByUsername;
	}

	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}

	public String getCreatedByEmail() {
		return createdByEmail;
	}

	public void setCreatedByEmail(String createdByEmail) {
		this.createdByEmail = createdByEmail;
	}

	public String getCreatedByCompanyCode() {
		return createdByCompanyCode;
	}

	public void setCreatedByCompanyCode(String createdByCompanyCode) {
		this.createdByCompanyCode = createdByCompanyCode;
	}

	public String getCreatedByCompanyName() {
		return createdByCompanyName;
	}

	public void setCreatedByCompanyName(String createdByCompanyName) {
		this.createdByCompanyName = createdByCompanyName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedByCode() {
		return updatedByCode;
	}

	public void setUpdatedByCode(String updatedByCode) {
		this.updatedByCode = updatedByCode;
	}

	public String getUpdatedByName() {
		return updatedByName;
	}

	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}

	public String getUpdatedByUsername() {
		return updatedByUsername;
	}

	public void setUpdatedByUsername(String updatedByUsername) {
		this.updatedByUsername = updatedByUsername;
	}

	public String getUpdatedByEmail() {
		return updatedByEmail;
	}

	public void setUpdatedByEmail(String updatedByEmail) {
		this.updatedByEmail = updatedByEmail;
	}

	public String getUpdatedByCompanyCode() {
		return updatedByCompanyCode;
	}

	public void setUpdatedByCompanyCode(String updatedByCompanyCode) {
		this.updatedByCompanyCode = updatedByCompanyCode;
	}

	public String getUpdatedByCompanyName() {
		return updatedByCompanyName;
	}

	public void setUpdatedByCompanyName(String updatedByCompanyName) {
		this.updatedByCompanyName = updatedByCompanyName;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}
